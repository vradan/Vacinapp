package fatecsp.ads.ihc.vacinapp.processoService;

import fatecsp.ads.ihc.vacinapp.processoService.dao.*;

public class Factory {
	
	private static UsuarioService instanceUsuarioDAO;
	private static VacinaService instanceVacinaDAO;
	
	public synchronized UsuarioService getInstanceUsuarioDAO() {
		return instanceUsuarioDAO == null ? new UsuarioDAO() : instanceUsuarioDAO;
	}
	
	public synchronized VacinaService getInstanceVacinaDAO() {
		return instanceVacinaDAO == null ? new VacinaDAO() : instanceVacinaDAO;
	}

}
