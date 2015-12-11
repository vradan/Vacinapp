package fatecsp.ads.ihc.vacinapp.bean;

import java.text.SimpleDateFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.constants.Perfil;
import fatecsp.ads.ihc.vacinapp.entity.constants.Sexo;
import fatecsp.ads.ihc.vacinapp.processoService.Delegate;
import fatecsp.ads.ihc.vacinapp.processoService.ProcessoService;

@ManagedBean(name = "configuracao")
@ViewScoped
public class ConfiguracaoBean {

	private ProcessoService delegate;
	
	private Usuario usuario;
	private String senha;
	private String repitaSenha;
	private String data;
	private char sexo;
	
	public ConfiguracaoBean() {
		this.usuario = UsuarioBean.getUsuarioLogado();
		this.delegate = new Delegate();
		this.sexo = usuario.getSexo().getSexo();
	}
	
	public String salvarDados() {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			if (senha.equals("") || senha.equals(repitaSenha)) {
				if (!senha.equals("")) {
					usuario.setPassword(senha);	
				}

				if (data.trim().length() == 10) {
					usuario.setDataNascimento(df.parse(data));
				} else {
					throw new Exception("Data inválida");
				}
				
				usuario.setSexo(Sexo.getSexoBySigla(sexo));

				delegate.alteraDadosUsuario(usuario);
				
				UsuarioBean.setUsuarioLogado(usuario);
				
				if (usuario.getPerfil().getId().equals(Perfil.AGENTE_SAUDE)) {
					return "solicitacoes";
				} else {
					return "minhasVacinas";
				}
			} else {
				UsuarioBean.setUsuarioMessage("Erro ao atualizar dados!", "As senhas não são iguais");
			}
			
		} catch (Exception e) {
			UsuarioBean.setUsuarioMessage("Erro ao alterar dados!", e.getMessage());
			e.printStackTrace();
		}
		return "configuracao";
	}
	
	public String removeUsuario() {
		try {
			delegate.deleteUsuario(usuario);
			UsuarioBean.doLogout();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "login";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRepitaSenha() {
		return repitaSenha;
	}

	public void setRepitaSenha(String repitaSenha) {
		this.repitaSenha = repitaSenha;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
}
