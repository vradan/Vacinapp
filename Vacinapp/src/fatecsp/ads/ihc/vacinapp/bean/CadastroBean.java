package fatecsp.ads.ihc.vacinapp.bean;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fatecsp.ads.ihc.vacinapp.entity.Unidade;
import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.UsuarioPerfil;
import fatecsp.ads.ihc.vacinapp.entity.constants.Perfil;
import fatecsp.ads.ihc.vacinapp.entity.constants.Sexo;
import fatecsp.ads.ihc.vacinapp.processoService.Delegate;
import fatecsp.ads.ihc.vacinapp.processoService.ProcessoService;

@ManagedBean(name = "cadastro")
@RequestScoped
public class CadastroBean {
	
	private ProcessoService delegate;
	
	private Usuario usuario;
	private List<Unidade> unidades;

	private int unidadeID;
	
	private String data;
	private String repitaSenha;
	private String message;
	
	private char sexo;
	private char perfil;

	public CadastroBean() {
		delegate = new Delegate();
		usuario = new Usuario();
		
		try {
			unidades = delegate.getUnidades();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doCadastro() {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		try {
			if (usuario.getPassword().equals(repitaSenha)) {
				usuario.setDataNascimento(df.parse(data));
				usuario.setUnidade(loadUnidade());
				if (usuario.getPerfil().getId().equals(Perfil.AGENTE_SAUDE) && usuario.getUnidade() == null) {
					message = "Um agente da saúde deve escolher uma unidade";
				} else {
					if (!usuario.getPerfil().getId().equals(Perfil.AGENTE_SAUDE)) {
						usuario.setUnidade(null);
					}
					delegate.cadastraUsuario(usuario);
					UsuarioBean.setUsuarioLogado(usuario);
					
					if (usuario.getPerfil().getId().equals(Perfil.AGENTE_SAUDE)) {
						UsuarioBean.redirect("paginas/agente/solicitacoes");
					} else {
						UsuarioBean.redirect("paginas/usuario/minhasVacinas");
					}
				}
			} else {
				message = "As senhas não são iguais!";
			}
		} catch (NullPointerException ne) {
			message = "Não podem haver campos vazios!";
		} catch (Exception e) {
			message = e.getMessage();
			e.printStackTrace();
		}
	}
	
	public Unidade loadUnidade() {
		Unidade unidadeSelecionada = null;
		for (Unidade unidade : unidades) {
			if (unidade.getId() == unidadeID) {
				unidadeSelecionada = unidade;
				break;
			}
		}
		return unidadeSelecionada;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public int getUnidadeID() {
		return unidadeID;
	}

	public void setUnidadeID(int unidadeID) {
		this.unidadeID = unidadeID;
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
		usuario.setSexo(Sexo.getSexoBySigla(sexo));
	}

	public char getPerfil() {
		return perfil;
	}

	public void setPerfil(char perfil) {
		this.perfil = perfil;
		
		if (usuario.getPerfil() == null)
			usuario.setPerfil(new UsuarioPerfil());
		
		usuario.getPerfil().setId(Perfil.getPerfilByID(perfil));
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
