package fatecsp.ads.ihc.vacinapp.processoService.dao;

import fatecsp.ads.ihc.vacinapp.entity.Usuario;

public interface UsuarioService {
	
	public void cadastraUsuario(Usuario usuario) throws Exception;
	
	public void removeUsuario(Usuario usuario) throws Exception;
	
	public void atualizaUsuario(Usuario usuario) throws Exception;

	public Usuario getUsuarioByEmail(String email) throws Exception;

}
