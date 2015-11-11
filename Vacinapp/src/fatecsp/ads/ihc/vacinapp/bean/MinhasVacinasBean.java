package fatecsp.ads.ihc.vacinapp.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fatecsp.ads.ihc.vacinapp.entity.Aplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Calendario;
import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.processoService.Delegate;
import fatecsp.ads.ihc.vacinapp.processoService.ProcessoService;

@ManagedBean(name = "minhasVacinas")
@RequestScoped
public class MinhasVacinasBean {

	private ProcessoService delegate;
	
	private Usuario usuario;
	private List<Aplicacao> aplicacoes;
	private Calendario calendario;
	
	public MinhasVacinasBean() {
		this.delegate = new Delegate();
		
		usuario = UsuarioBean.getUsuarioLogado();
		
		try {
			aplicacoes = delegate.getUsuarioAplicacoes(usuario);
		} catch (Exception e) {
			UsuarioBean.setUsuarioMessage("Erro ao trazer aplicações", e.getMessage());
			System.out.println("Erro ao trazer aplicações do usuário");
			e.printStackTrace();
		}
	}
	
	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public void setAplicacoes(List<Aplicacao> aplicacoes) {
		this.aplicacoes = aplicacoes;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	
}
