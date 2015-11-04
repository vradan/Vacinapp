package fatecsp.ads.ihc.vacinapp.entity.constants;

public enum Sexo {

	MASCULINO('M'), FEMININO('F');
	
	private char sexo;
	
	Sexo(char sexo) {
		this.setSexo(sexo);
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

}
