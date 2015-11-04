package fatecsp.ads.ihc.vacinapp.processoService;

import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.Vacina;

public interface ProcessoService {

	public void cadastraUsuario(Usuario usuario) throws Exception;
	
	public void cadastraVacina(Vacina vacina) throws Exception;
	
}
