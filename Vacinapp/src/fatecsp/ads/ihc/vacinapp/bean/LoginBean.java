package fatecsp.ads.ihc.vacinapp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.constants.Perfil;
import fatecsp.ads.ihc.vacinapp.processoService.Delegate;
import fatecsp.ads.ihc.vacinapp.processoService.ProcessoService;

@ManagedBean(name = "login")
@RequestScoped
public class LoginBean {

	private ProcessoService delegate;
	
	private Usuario usuario;
	
	private String message;
	
	public LoginBean() {
		delegate = new Delegate();
		usuario = new Usuario();
		message = "";
	}
	
	public void doLogin() {
		try {			
			Usuario usuarioLogado = delegate.doLogin(usuario);
			UsuarioBean.setUsuarioLogado(usuarioLogado);
			
			if (usuarioLogado.getPerfil().getId().equals(Perfil.AGENTE_SAUDE)) {
				UsuarioBean.redirect("paginas/agente/solicitacoes");
			} else {
				UsuarioBean.redirect("paginas/usuario/minhasVacinas");
			}
		} catch (Exception e){
			message = e.getMessage();
			System.out.println(message);
		}
	}
	
	public String doLogout() {
		UsuarioBean.doLogout();
		return "login";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
