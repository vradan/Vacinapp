package fatecsp.ads.ihc.vacinapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vpp_vacina")
@SequenceGenerator(name = "seq_vacina", sequenceName = "seq_vacina", initialValue = 1, allocationSize = 1)
public class Vacina {

	@Id
	@Column(name = "id_vacina")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vacina")
	private int id;
	
	@Column(name = "str_nome")
	private String nome;
	
	@Column(name = "str_descricao")
	private String descricao;
	
	@Column(name = "bol_obrigatoria")
	private boolean obrigatoria;

	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isObrigatoria() {
		return obrigatoria;
	}

	public void setObrigatoria(boolean obrigatoria) {
		this.obrigatoria = obrigatoria;
	}

}