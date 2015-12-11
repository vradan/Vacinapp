package fatecsp.ads.ihc.vacinapp.processoService;

import fatecsp.ads.ihc.vacinapp.processoService.dao.*;

public class Factory {
	
	private static AplicacaoService instanceAplicacaoDAO;
	private static CalendarioService instanceCalendarioDAO;
	private static RegistroAplicacoesService instanceRegistroAplicacoesDAO;
	private static VacinaService instanceVacinaDAO;
	private static UsuarioService instanceUsuarioDAO;
	private static LocalDAO instanceLocalDAO;

	public synchronized AplicacaoService getInstanceAplicacaoDAO() {
		return instanceAplicacaoDAO == null ? new AplicacaoDAO() : instanceAplicacaoDAO;
	}
	
	public synchronized CalendarioService getInstanceCalendarioDAO() {
		return instanceCalendarioDAO == null ? new CalendarioDAO() : instanceCalendarioDAO;
	}
	
	public synchronized RegistroAplicacoesService getInstanceRegistroAplicacoesDAO() {
		return instanceRegistroAplicacoesDAO == null ? new RegistroAplicacoesDAO() : instanceRegistroAplicacoesDAO;
	}
	
	public synchronized VacinaService getInstanceVacinaDAO() {
		return instanceVacinaDAO == null ? new VacinaDAO() : instanceVacinaDAO;
	}
	
	public synchronized UsuarioService getInstanceUsuarioDAO() {
		return instanceUsuarioDAO == null ? new UsuarioDAO() : instanceUsuarioDAO;
	}

	public synchronized LocalService getInstanceLocalDAO() {
		return instanceLocalDAO == null ? new LocalDAO() : instanceLocalDAO;
	}

}
