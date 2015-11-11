package fatecsp.ads.ihc.vacinapp.processoService.dao;

import javax.persistence.Query;

import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.exception.UsuarioNotFoundException;
import fatecsp.ads.ihc.vacinapp.utils.HibernateUtils;

public class UsuarioDAO extends HibernateDAO implements UsuarioService {

	@Override
	public void cadastraUsuario(Usuario usuario) throws Exception {
		persist(usuario);
	}
	
	@Override
	public void removeUsuario(Usuario usuario) throws Exception {
		//TODO
	}
	
	@Override
	public void atualizaUsuario(Usuario usuario) throws Exception {
		//TODO
	}

	@Override
	public Usuario getUsuarioByEmail(Usuario usuario) throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		String sql = "  SELECT U FROM Usuario U"
				+ "		WHERE  U.email = :email ";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("email", usuario.getEmail());
		
		try {
			if (!query.getResultList().isEmpty()) {
				return (Usuario) query.getResultList().get(0);
			}
			throw new UsuarioNotFoundException("Usuário não encontrado");
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}
	
}
