package fatecsp.ads.ihc.vacinapp.bean;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.processoService.Delegate;
import fatecsp.ads.ihc.vacinapp.processoService.ProcessoService;

@ManagedBean(name = "solicitacoes")
@ViewScoped
public class SolicitacoesBean {

	private ProcessoService delegate;
	
	private Usuario agente;
	
	private List<RegistroAplicacao> registros;
	private RegistroAplicacao registroSelecionado;
	
	private int usuarioIdade;
	private int registroID;
	
	private String filtro;
	private String message;
	
	public SolicitacoesBean() {
		this.delegate = new Delegate();
		this.agente = UsuarioBean.getUsuarioLogado();
		
		try {
			registros = delegate.getRegistrosAplicacoesPendentes(agente.getUnidade());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doFiltro() {
		try {
			registros = new ArrayList<RegistroAplicacao>();
			
			for (RegistroAplicacao registro : delegate.getRegistrosAplicacoesPendentes(agente.getUnidade())) {
				if (filtro.trim().equals("") || registro.getUsuario().getNome().toLowerCase().contains(filtro.toLowerCase())) {
					registros.add(registro);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showModal() {		
		for (RegistroAplicacao registro : registros) {
			if (registro.getId() == registroID) {				
				registroSelecionado = registro;
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(registroSelecionado.getUsuario().getDataNascimento());
				
				LocalDate now = LocalDate.now();
				LocalDate nascimento = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
				
				Period p = Period.between(nascimento, now);
				
				usuarioIdade = p.getYears();
				break;
			}
		}
	}

	public void doAplicacao() {
		try {
			if (!registroSelecionado.getVacinaLote().trim().equals("")) {
				delegate.registraAplicacao(registroSelecionado);
				message = "";
			} else {
				message = "O campo \"lote\" não pode estar vazio!";
			}
		} catch (Exception e) {
			UsuarioBean.setUsuarioMessage("Erro ao registrar aplicação!", e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void refuseAplicacao() {
		try {
			message = "";
			delegate.deleteRegistroAplicacoes(registroSelecionado);
		} catch (Exception e) {
			UsuarioBean.setUsuarioMessage("Erro ao registrar aplicação!", e.getMessage());
			e.printStackTrace();
		}
	}

	public Usuario getAgente() {
		return agente;
	}

	public void setAgente(Usuario agente) {
		this.agente = agente;
	}

	public List<RegistroAplicacao> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroAplicacao> registros) {
		this.registros = registros;
	}
	
	public RegistroAplicacao getRegistroSelecionado() {
		return registroSelecionado;
	}

	public void setRegistroSelecionado(RegistroAplicacao registroSelecionado) {
		this.registroSelecionado = registroSelecionado;
	}

	public int getUsuarioIdade() {
		return usuarioIdade;
	}

	public void setUsuarioIdade(int usuarioIdade) {
		this.usuarioIdade = usuarioIdade;
	}

	public int getRegistroID() {
		return registroID;
	}

	public void setRegistroID(int registroID) {
		this.registroID = registroID;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
