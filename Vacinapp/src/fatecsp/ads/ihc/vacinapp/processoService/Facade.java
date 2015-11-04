package fatecsp.ads.ihc.vacinapp.processoService;

import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.Vacina;
import fatecsp.ads.ihc.vacinapp.processoService.dao.UsuarioService;
import fatecsp.ads.ihc.vacinapp.processoService.dao.VacinaService;

public class Facade implements ProcessoService {

	private static Factory factory = new Factory();
	
	private UsuarioService usuarioDAO = factory.getInstanceUsuarioDAO();
	private VacinaService vacinaDAO = factory.getInstanceVacinaDAO();
	
	public Facade() {
		if (factory == null)
			factory = new Factory();
	}

	@Override
	public void cadastraUsuario(Usuario usuario) throws Exception {
		usuarioDAO.cadastraUsuario(usuario);
	}

	@Override
	public void cadastraVacina(Vacina vacina) throws Exception {
		vacinaDAO.cadastraVacina(vacina);
	}

}
