package fatecsp.ads.ihc.vacinapp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sun.jmx.snmp.Timestamp;

import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.constants.Sexo;
import fatecsp.ads.ihc.vacinapp.processoService.Delegate;
import fatecsp.ads.ihc.vacinapp.processoService.ProcessoService;

@ManagedBean(name = "cadastroUsuario")
@RequestScoped
public class CadastroUsuarioBean {

	private ProcessoService delegate = new Delegate();
	
	private Usuario usuario;
	
	public CadastroUsuarioBean() {
		usuario = new Usuario();
		
		usuario.setNome("Lucas");
		usuario.setSobrenome("Morinigo");
		usuario.setSexo(Sexo.MASCULINO);
		usuario.setEmail("teste@teste.com");
		usuario.setDataNascimento(new Timestamp().getDate());
		usuario.setPassword("teste");
		
		try {
			delegate.cadastraUsuario(usuario);
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar usuario!");
			e.printStackTrace();
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
