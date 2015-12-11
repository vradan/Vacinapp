package fatecsp.ads.ihc.vacinapp.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatecsp.ads.ihc.vacinapp.composite.AplicacaoComposite;
import fatecsp.ads.ihc.vacinapp.composite.MinhasVacinasComposite;
import fatecsp.ads.ihc.vacinapp.entity.Aplicacao;
import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Unidade;
import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.processoService.Delegate;
import fatecsp.ads.ihc.vacinapp.processoService.ProcessoService;

@ManagedBean(name = "minhasVacinas")
@ViewScoped
public class MinhasVacinasBean {

	private ProcessoService delegate;
	
	private Usuario usuario;
	private List<MinhasVacinasComposite> minhasVacinasComposite;
	private List<Unidade> unidades;
	
	private Aplicacao aplicacaoSelecionada;
	private RegistroAplicacao registroAplicacaoSelecionada;
	
	private int aplicacaoID;
	private int unidadeID;
	
	private String filtro;
	
	public MinhasVacinasBean() {
		this.delegate = new Delegate();

		usuario = UsuarioBean.getUsuarioLogado();

		try {
			minhasVacinasComposite = delegate.getUsuarioAplicacoesComposite(usuario);
			unidades = delegate.getUnidades();
			
			if (minhasVacinasComposite.isEmpty()) {
				minhasVacinasComposite = null;
			}
		} catch (Exception e) {
			UsuarioBean.setUsuarioMessage("Erro ao trazer aplicações", e.getMessage());
			System.out.println("Erro ao trazer aplicações do usuário");
			e.printStackTrace();
		}
	}
	
	public void showModalAplicacao() {
		for (MinhasVacinasComposite minhasVacinas : minhasVacinasComposite) {
			for (AplicacaoComposite aplicacoesComposite : minhasVacinas.getAplicacoesComposite()) {
				if (aplicacoesComposite.getAplicacao().getId() == aplicacaoID) {
					aplicacaoSelecionada = aplicacoesComposite.getAplicacao();
					break;
				}
			}
		}
	}
	
	public void showModalInfo() {
		try {
			showModalAplicacao();
			registroAplicacaoSelecionada = delegate.getRegistroByAplicacaoAndUserID(usuario.getId(), aplicacaoSelecionada.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String sendSolicitacao() {
		RegistroAplicacao registroAplicacoes = new RegistroAplicacao();

		registroAplicacoes.setUsuario(usuario);
		registroAplicacoes.setAplicacao(aplicacaoSelecionada);
		registroAplicacoes.setDataAplicacao(new Date());
		
		for (Unidade unidade : unidades) {
			if (unidade.getId() == unidadeID) {
				registroAplicacoes.setUnidade(unidade);
				break;
			}
		}

		try {
			delegate.cadastraRegistroAplicacoes(registroAplicacoes);
		} catch (Exception e) {
			UsuarioBean.setUsuarioMessage("Erro ao realizar solicitação!", e.getMessage());
			e.printStackTrace();
		}
		return "minhasVacinas";
	}
	
	public void doFiltro() {
		try {
			 minhasVacinasComposite = new ArrayList<MinhasVacinasComposite>();
			
			for (MinhasVacinasComposite minhaVacinaComposite : delegate.getUsuarioAplicacoesComposite(usuario)) {
				List<AplicacaoComposite> aplicacoesComposite = new ArrayList<AplicacaoComposite>();
				
				for (AplicacaoComposite aplicacaoComposite : minhaVacinaComposite.getAplicacoesComposite()) {
					if (filtro.trim().equals("") || aplicacaoComposite.getAplicacao().getVacina().getNome().trim().toLowerCase().contains(filtro.trim().toLowerCase())) {
						aplicacoesComposite.add(aplicacaoComposite);
					}
				}
				minhaVacinaComposite.setAplicacoesComposite(aplicacoesComposite);
				minhasVacinasComposite.add(minhaVacinaComposite);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MinhasVacinasComposite> getMinhasVacinasComposite() {
		return minhasVacinasComposite;
	}

	public List<Unidade> getUnidades() {
		return unidades;
	}

	public Aplicacao getAplicacaoSelecionada() {
		return aplicacaoSelecionada;
	}

	public void setAplicacaoSelecionada(Aplicacao aplicacaoSelecionada) {
		this.aplicacaoSelecionada = aplicacaoSelecionada;
	}

	public RegistroAplicacao getRegistroAplicacaoSelecionada() {
		return registroAplicacaoSelecionada;
	}

	public void setRegistroAplicacaoSelecionada(RegistroAplicacao registroAplicacaoSelecionada) {
		this.registroAplicacaoSelecionada = registroAplicacaoSelecionada;
	}

	public int getAplicacaoID() {
		return aplicacaoID;
	}

	public void setAplicacaoID(int aplicacaoID) {
		this.aplicacaoID = aplicacaoID;
	}

	public int getUnidadeID() {
		return unidadeID;
	}

	public void setUnidadeID(int unidadeID) {
		this.unidadeID = unidadeID;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
}
