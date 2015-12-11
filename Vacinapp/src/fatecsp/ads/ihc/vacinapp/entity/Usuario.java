package fatecsp.ads.ihc.vacinapp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import fatecsp.ads.ihc.vacinapp.entity.constants.Sexo;

@Entity
@Table(name = "vpp_usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", initialValue = 1, allocationSize = 1)
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidade;
	
	@Column(name = "str_nome")
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "chr_perfil")
	private UsuarioPerfil perfil;
	
	@Column(name = "str_email")
	private String email;
	
	@Column(name = "dat_nascimento")
	private Date dataNascimento;
	
	@Column(name = "chr_sexo")
	private char sexo;
	
	@Column(name = "str_password")
	private String password;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval =  true)
	private List<RegistroAplicacao>	registros;
	
	public int getId() {
		return id;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UsuarioPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(UsuarioPerfil perfil) {
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return Sexo.getSexoBySigla(sexo);
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo.getSexo();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RegistroAplicacao> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroAplicacao> registros) {
		this.registros = registros;
	}

}
