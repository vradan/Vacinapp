package fatecsp.ads.ihc.vacinapp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationController")
@RequestScoped
public class NavigationControllerBean {
	
	public String goToLogin() {
		return "login";
	}
	
	public String goToCadastro() {
		return "cadastro";
	}
	
	public String goToMinhasVacinas() {
		return "minhasVacinas";
	}
	
	public String goToSolicitacoes() {
		return "solicitacoes";
	}
	
	public String goToVacinas() {
		return "vacinas";
	}
	
	public String goToLocais() {
		return "locais";
	}
	
	public String goToConfiguracao() {
		return "configuracao";
	}
	
}