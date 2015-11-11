package fatecsp.ads.ihc.vacinapp.entity;

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
@Table(name = "vpp_registro_aplicacoes")
@SequenceGenerator(name = "seq_registro_aplicacoes", sequenceName = "seq_registro_aplicacoes", initialValue = 1, allocationSize = 1)
public class RegistroAplicacoes {

	@Id
	@Column(name = "id_registro_aplicacoes")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_registro_aplicacoes")
	private int id;
	
	@JoinColumn(name = "id_usuario")
	@OneToOne
	private Usuario usuario; 

	@JoinColumn(name = "id_aplicacao")
	@OneToOne
	private Aplicacao aplicacao;

	@Column(name = "dat_aplicacao")
	private Date dataAplicacao;

	public int getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

}