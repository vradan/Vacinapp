package fatecsp.ads.ihc.vacinapp.entity.constants;

public enum Perfil {

	ADMINISTRADOR('A'), AGENTE_SAUDE('F'), USUARIO('U');
	
	private char perfilID;
	
	Perfil(char perfilID) {
		this.perfilID= perfilID;
	}
	
	public char getPerfilID() {
		return perfilID;
	}
	
	public void setPerfilID(char perfilID) {
		this.perfilID = perfilID;
	}
	
	public static Perfil getPerfilByID(char perfilID) {
		switch (perfilID) {
			case 'A':
				return Perfil.ADMINISTRADOR;
			case 'F':
				return Perfil.AGENTE_SAUDE;
			case 'U':
				return Perfil.USUARIO;
			default:
				return null;
		}
	}
	
}
