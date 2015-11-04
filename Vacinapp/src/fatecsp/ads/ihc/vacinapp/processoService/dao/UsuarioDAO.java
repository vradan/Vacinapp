package fatecsp.ads.ihc.vacinapp.processoService.dao;

import fatecsp.ads.ihc.vacinapp.entity.Usuario;

public class UsuarioDAO extends HibernateDAO implements UsuarioService {

	@Override
	public void cadastraUsuario(Usuario usuario) throws Exception {
		persist(usuario);
	}
	
}
