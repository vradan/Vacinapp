package fatecsp.ads.ihc.vacinapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import fatecsp.ads.ihc.vacinapp.entity.constants.Sexo;

@Entity
@Table(name = "vpp_calendario")
@SequenceGenerator(name = "seq_calendario", sequenceName = "seq_calendario", initialValue = 1, allocationSize = 1)
public class Calendario {

	@Id
	@Column(name = "id_calendario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_calendario")
	private int id;
	
	@Column(name = "str_nome")
	private String nome;
	
	@Column(name = "int_faixa_inicio")
	private int faixaInicio;

	@Column(name = "int_faixa_fim")
	private int faixaFim;
	
	@Column(name = "chr_sexo")
	private char sexo;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getFaixaInicio() {
		return faixaInicio;
	}

	public void setFaixaInicio(int faixaInicio) {
		this.faixaInicio = faixaInicio;
	}

	public int getFaixaFim() {
		return faixaFim;
	}

	public void setFaixaFim(int faixaFim) {
		this.faixaFim = faixaFim;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo != null ? sexo.getSexo() : null;
	}

}
