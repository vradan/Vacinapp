package fatecsp.ads.ihc.vacinapp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatecsp.ads.ihc.vacinapp.entity.Unidade;
import fatecsp.ads.ihc.vacinapp.processoService.Delegate;
import fatecsp.ads.ihc.vacinapp.processoService.ProcessoService;

@ManagedBean(name = "local")
@ViewScoped
public class LocalBean {
	
	private ProcessoService delegate;
	
	private List<Unidade> unidades;
	private Unidade unidadeSelecionada;

	private int unidadeID;
	
	private String filtro;
	
	public LocalBean() {
		this.delegate = new Delegate();
		try {
			unidades = delegate.getUnidades();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doFiltro() {
		try {
			unidades = new ArrayList<Unidade>();
			
			for (Unidade unidade : delegate.getUnidades()) {
				if (filtro.trim().equals("") || unidade.getNome().toLowerCase().contains(filtro.toLowerCase())) {
					unidades.add(unidade);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showModal() {
		for (Unidade unidade : unidades) {
			if (unidade.getId() == unidadeID) {
				unidadeSelecionada = unidade;
				break;
			}
		}
	}

	public List<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public Unidade getUnidadeSelecionada() {
		return unidadeSelecionada;
	}

	public void setUnidadeSelecionada(Unidade unidadeSelecionada) {
		this.unidadeSelecionada = unidadeSelecionada;
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
