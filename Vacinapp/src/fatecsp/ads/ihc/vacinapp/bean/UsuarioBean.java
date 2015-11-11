package fatecsp.ads.ihc.vacinapp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fatecsp.ads.ihc.vacinapp.entity.Usuario;

@ManagedBean(name = "usuario")
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;
	
	public static void setUsuarioMessage(String header, String message) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("messageHeader", header);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("messageContent", message);
	}
	
	public static String getMessageHeader() {
		Object header = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("messageHeader");
		return header == null ? null : (String) header; 
	}
	
	public static String getMessageContent() {
		Object message = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("messageContent");
		return message == null ? null : (String) message; 
	}
	
	public static void setUsuarioLogado(Usuario usuario) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", usuario);
	}
	
	public static Usuario getUsuarioLogado() {
		Object user = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogado");
		return user == null ? null : (Usuario) user;
	}
	
	public static void doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	public static void redirect(String pagina) throws Exception {
		String path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
		FacesContext.getCurrentInstance().getExternalContext().redirect(path + "/" + pagina + ".jsf");
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = UsuarioBean.getUsuarioLogado();
		return usuario;
	}
	
}