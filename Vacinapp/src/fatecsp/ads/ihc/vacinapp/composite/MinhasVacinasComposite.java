package fatecsp.ads.ihc.vacinapp.composite;

import java.util.List;

import fatecsp.ads.ihc.vacinapp.entity.Calendario;

public class MinhasVacinasComposite {

	private Calendario calendario;

	private List<AplicacaoComposite> aplicacoesComposite;

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public List<AplicacaoComposite> getAplicacoesComposite() {
		return aplicacoesComposite;
	}

	public void setAplicacoesComposite(List<AplicacaoComposite> aplicacoesComposite) {
		this.aplicacoesComposite = aplicacoesComposite;
	}

}
