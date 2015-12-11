package fatecsp.ads.ihc.vacinapp.processoService.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Unidade;
import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.utils.HibernateUtils;

public class RegistroAplicacoesDAO extends HibernateDAO implements RegistroAplicacoesService {

	@Override
	public void cadastraRegistroAplicacoes(RegistroAplicacao registroAplicacoes) throws Exception {
		persist(registroAplicacoes);
	}

	@Override
	public void removeRegistroAplicacoes(RegistroAplicacao registroAplicacoes) throws Exception {
		remove(RegistroAplicacao.class, registroAplicacoes.getId());
	}

	@Override
	public void atualizaRegistroAplicacoes(RegistroAplicacao registroAplicacoes) throws Exception {
		registroAplicacoes.setAprovada(true);
		update(registroAplicacoes);
	}

	@Override
	public List<RegistroAplicacao> getRegistrosAplicacoesPendentes(Unidade unidade) throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		String sql = "SELECT R "
				+ "		FROM RegistroAplicacao R "
				+ "		WHERE R.unidade.id = :unidade "
				+ "			AND R.aprovada = false ";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("unidade", unidade.getId());
		
		try {
			
			List<?> results = query.getResultList();
			
			if (!results.isEmpty()) {
				
				List<RegistroAplicacao> registros = new ArrayList<RegistroAplicacao>();
				
				for (Object obj : results) {
					registros.add((RegistroAplicacao) obj);
				}
				
				return registros;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<RegistroAplicacao> getRegistrosAplicacoesByUser(Usuario usuario) throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		String sql = "SELECT R "
				+ "		FROM RegistroAplicacao R "
				+ "		WHERE R.usuario.id = :id ";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", usuario.getId());
		
		try {
			
			List<?> results = query.getResultList();
			
			if (!results.isEmpty()) {
				
				List<RegistroAplicacao> registros = new ArrayList<RegistroAplicacao>();
				
				for (Object obj : results) {
					registros.add((RegistroAplicacao) obj);
				}
				
				return registros;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public RegistroAplicacao getRegistroByAplicacaoAndUserID(int usuarioID, int aplicacaoID) throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		String sql = "  SELECT R FROM RegistroAplicacao R"
				+ "		WHERE  R.usuario.id = :usuarioID"
				+ "			AND R.aplicacao.id = :aplicacaoID ";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("usuarioID", usuarioID);
		query.setParameter("aplicacaoID", aplicacaoID);
		
		try {
			if (!query.getResultList().isEmpty()) {
				return (RegistroAplicacao) query.getResultList().get(0);
			}
			throw new Exception("Aplicação não encontrada");
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
