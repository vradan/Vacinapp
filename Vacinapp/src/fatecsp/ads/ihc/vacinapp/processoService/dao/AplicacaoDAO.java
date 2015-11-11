package fatecsp.ads.ihc.vacinapp.processoService.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import fatecsp.ads.ihc.vacinapp.entity.Aplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Calendario;
import fatecsp.ads.ihc.vacinapp.utils.HibernateUtils;

public class AplicacaoDAO extends HibernateDAO implements AplicacaoService {

	@Override
	public void cadastraAplicacao(Aplicacao aplicacao) throws Exception {
		persist(aplicacao);
	}
	
	@Override
	public void removeAplicacao(Aplicacao aplicacao) throws Exception {
		//TODO
	}
	
	@Override
	public void atualizaAplicacao(Aplicacao aplicacao) throws Exception {
		//TODO
	}

	@Override
	public List<Aplicacao> getAplicacoesByCalendario(Calendario calendario) throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		String sql = "SELECT A "
				+ "		FROM Aplicacao A "
				+ "		LEFT JOIN A.calendario C "
				+ "		WHERE C.id = :calendarioId ";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("calendarioId", calendario.getId());
		
		try {
			
			List<?> results = query.getResultList();
			
			if (!results.isEmpty()) {
				
				List<Aplicacao> aplicacoes = new ArrayList<Aplicacao>();
				
				for (Object obj : results) {
					aplicacoes.add((Aplicacao) obj);
				}
				
				return aplicacoes;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}
	
}
