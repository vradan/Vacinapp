package fatecsp.ads.ihc.vacinapp.bean;

import java.text.SimpleDateFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.constants.Sexo;
import fatecsp.ads.ihc.vacinapp.processoService.Delegate;
import fatecsp.ads.ihc.vacinapp.processoService.ProcessoService;

@ManagedBean(name = "cadastro")
@RequestScoped
public class CadastroBean {
	
	private ProcessoService delegate;
	
	private Usuario usuario;
	
	private String data;
	private String repitaSenha;
	private char sexo;
	private String message;

	public CadastroBean() {
		delegate = new Delegate();
		usuario = new Usuario();
	}
	
	public void doCadastro() {
		
		usuario.setSexo(Sexo.getSexoBySigla(sexo));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		try {
			if (usuario.getPassword().equals(repitaSenha)) {
				usuario.setDataNascimento(df.parse(data));
				delegate.cadastraUsuario(usuario);
				UsuarioBean.setUsuarioLogado(usuario);
				UsuarioBean.redirect("paginas/minhasVacinas");
			} else {
				message = "As senhas não são iguais!";
			}
		} catch (NullPointerException ne) {
			message = "Não podem haver campos vazios!";
		} catch (Exception e) {
			message = "Erro ao cadastrar usuário";
			e.printStackTrace();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getRepitaSenha() {
		return repitaSenha;
	}

	public void setRepitaSenha(String repitaSenha) {
		this.repitaSenha = repitaSenha;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
