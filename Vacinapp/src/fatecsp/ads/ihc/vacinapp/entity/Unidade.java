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
@Table(name = "vpp_unidade")
@SequenceGenerator(name = "seq_unidade", sequenceName = "seq_unidade", initialValue = 1, allocationSize = 1)
public class Unidade {

	@Id
	@Column(name = "id_unidade")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_unidade")
	private int id;
	
	@JoinColumn(name = "id_cidade")
	@OneToOne
	private Cidade cidade;
	
	@Column(name = "str_suvis")
	private String suvis;

	@Column(name = "str_distrito")
	private String distrito;

	@Column(name = "str_nome")
	private String nome;

	@Column(name = "str_rua")
	private String rua;

	@Column(name = "str_numero")
	private String numero;

	@Column(name = "str_telefone")
	private String telefone;
	
	public int getId() {
		return id;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getSuvis() {
		return suvis;
	}

	public void setSuvis(String suvis) {
		this.suvis = suvis;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
