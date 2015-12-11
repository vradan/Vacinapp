package fatecsp.ads.ihc.vacinapp.composite;

import fatecsp.ads.ihc.vacinapp.entity.Aplicacao;

public class AplicacaoComposite {

	private Aplicacao aplicacao;
	
	private boolean aplicada;
	private boolean aprovada;
	
	private int doses;
	
	public AplicacaoComposite() {
		this.doses = 1;
		this.aplicada = false;
		this.aprovada = false;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public boolean getAplicada() {
		return aplicada;
	}

	public void setAplicada(boolean aplicada) {
		this.aplicada = aplicada;
	}

	public boolean getAprovada() {
		return aprovada;
	}

	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}

	public int getDoses() {
		return doses;
	}

	public void setDoses(int doses) {
		this.doses = doses;
	}

}