package fatecsp.ads.ihc.vacinapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import fatecsp.ads.ihc.vacinapp.entity.constants.Perfil;

@Entity
@Table(name = "vpp_perfil")
public class UsuarioPerfil {

	@Id
	@Column(name = "chr_perfil")
	private char id;

	@Column(name = "str_nome")
	private String nome;

	public void setId(Perfil perfil) {
		this.id = perfil.getPerfilID();
	}
	
	public Perfil getId() {
		return Perfil.getPerfilByID(id);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
