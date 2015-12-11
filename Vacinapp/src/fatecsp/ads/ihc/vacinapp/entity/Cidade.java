package fatecsp.ads.ihc.vacinapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vpp_cidade")
@SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade", initialValue = 1, allocationSize = 1)
public class Cidade {

	@Id
	@Column(name = "id_cidade")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cidade")
	private int id;
	
	@JoinColumn(name = "id_estado")
	@OneToOne
	private Estado estado;
	
	@Column(name = "str_nome")
	private String nome;

	public void setId(int id) {
		this.id = id;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
