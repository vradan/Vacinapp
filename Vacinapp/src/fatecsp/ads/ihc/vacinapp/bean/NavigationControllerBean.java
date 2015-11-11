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
	
}