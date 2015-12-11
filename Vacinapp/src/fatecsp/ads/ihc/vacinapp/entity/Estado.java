package fatecsp.ads.ihc.vacinapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vpp_estado")
@SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado", initialValue = 1, allocationSize = 1)
public class Estado {

	@Id
	@Column(name = "id_estado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estado")
	private int id;
	
	@Column(name = "str_nome")
	private String nome;

	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
