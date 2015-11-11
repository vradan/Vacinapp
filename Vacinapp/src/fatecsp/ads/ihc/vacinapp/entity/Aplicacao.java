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
@Table(name = "vpp_aplicacao")
@SequenceGenerator(name = "seq_aplicacao", sequenceName = "seq_aplicacao", initialValue = 1, allocationSize = 1)
public class Aplicacao {
	
	@Id
	@Column(name = "id_aplicacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aplicacao")
	private int id;
	
	@JoinColumn(name = "id_calendario")
	@OneToOne
	private Calendario calendario;
	
	@JoinColumn(name = "id_vacina")
	@OneToOne
	private Vacina vacina;
	
	@Column(name = "int_meses")
	private int periodoAplicacao;
	
	@Column(name = "bol_data_fixa")
	private boolean dataFixa;

	public int getId() {
		return id;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public int getPeriodoAplicacao() {
		return periodoAplicacao;
	}

	public void setPeriodoAplicacao(int periodoAplicacao) {
		this.periodoAplicacao = periodoAplicacao;
	}

	public boolean isDataFixa() {
		return dataFixa;
	}

	public void setDataFixa(boolean dataFixa) {
		this.dataFixa = dataFixa;
	}
	
}
