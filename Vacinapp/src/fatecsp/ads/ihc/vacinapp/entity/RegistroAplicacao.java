package fatecsp.ads.ihc.vacinapp.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "vpp_registro_aplicacao")
@SequenceGenerator(name = "seq_registro_aplicacao", sequenceName = "seq_registro_aplicacao", initialValue = 1, allocationSize = 1)
public class RegistroAplicacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_registro_aplicacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_registro_aplicacao")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidade; 

	@OneToOne
	@JoinColumn(name = "id_aplicacao")
	private Aplicacao aplicacao;

	@Column(name = "dat_aplicacao")
	private Date dataAplicacao;
	
	@Column(name = "bol_aprovada")
	private boolean aprovada;
	
	@Column(name = "str_vacina_lote")
	private String vacinaLote;

	public int getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public boolean getAprovada() {
		return aprovada;
	}

	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}

	public String getVacinaLote() {
		return vacinaLote;
	}

	public void setVacinaLote(String vacinaLote) {
		this.vacinaLote = vacinaLote;
	}

}