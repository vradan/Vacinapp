package fatecsp.ads.ihc.vacinapp.entity.constants;

public enum Sexo {

	MASCULINO('M'), FEMININO('F'), AMBOS('A');
	
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

	public static Sexo getSexoBySigla(char sigla) {
		switch (sigla) {
			case 'M':
				return Sexo.MASCULINO;
			case 'F':
				return Sexo.FEMININO;
			case 'A':
				return Sexo.AMBOS;
			default:
				return null;
		}
	}

}
