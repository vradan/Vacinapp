package fatecsp.ads.ihc.vacinapp.processoService;

import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.Vacina;

public class Delegate implements ProcessoService {

	private ProcessoService facade = new Facade();

	@Override
	public void cadastraUsuario(Usuario usuario) throws Exception {
		facade.cadastraUsuario(usuario);
	}

	@Override
	public void cadastraVacina(Vacina vacina) throws Exception {
		facade.cadastraVacina(vacina);		
	}
	
}