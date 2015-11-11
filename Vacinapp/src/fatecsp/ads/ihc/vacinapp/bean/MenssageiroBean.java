package fatecsp.ads.ihc.vacinapp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "menssageiro")
@RequestScoped
public class MenssageiroBean {

	private String header;
	private String message;
	
	public MenssageiroBean() {
		this.header = UsuarioBean.getMessageHeader();
		this.message = UsuarioBean.getMessageContent();
		UsuarioBean.setUsuarioMessage(null, "");
	}
	
	public String getHeader() {
		return header;
	}
	
	public String getMessage() {
		return message;
	}
	
}