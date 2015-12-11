package fatecsp.ads.ihc.vacinapp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatecsp.ads.ihc.vacinapp.entity.Vacina;
import fatecsp.ads.ihc.vacinapp.processoService.Delegate;
import fatecsp.ads.ihc.vacinapp.processoService.ProcessoService;

@ManagedBean(name = "vacinas")
@ViewScoped
public class VacinasBean {
	
	private ProcessoService delegate;
	
	private List<Vacina> vacinas;
	private Vacina vacinaSelecionada;
	
	private int vacinaID;
	
	private String filtro;
	
	public VacinasBean() {
		this.delegate = new Delegate();
		
		try {
			vacinas = delegate.getVacinas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doFiltro() {
		try {
			vacinas = new ArrayList<Vacina>();
			
			for (Vacina vacina : delegate.getVacinas()) {
				if (filtro.trim().equals("") || vacina.getNome().trim().toLowerCase().contains(filtro.trim().toLowerCase()))
					vacinas.add(vacina);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showModalVacina() {
		for (Vacina vacina : vacinas) {
			if (vacina.getId() == vacinaID) {
				vacinaSelecionada = vacina;
				break;
			}
		}
	}

	public List<Vacina> getVacinas() {
		return vacinas;
	}

	public Vacina getVacinaSelecionada() {
		return vacinaSelecionada;
	}

	public void setVacinaSelecionada(Vacina vacinaSelecionada) {
		this.vacinaSelecionada = vacinaSelecionada;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public int getVacinaID() {
		return vacinaID;
	}

	public void setVacinaID(int vacinaID) {
		this.vacinaID = vacinaID;
	}

}
