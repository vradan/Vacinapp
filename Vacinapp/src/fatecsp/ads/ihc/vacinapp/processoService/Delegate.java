package fatecsp.ads.ihc.vacinapp.processoService;

import java.util.List;

import fatecsp.ads.ihc.vacinapp.entity.Aplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Calendario;
import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacoes;
import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.Vacina;

public class Delegate implements ProcessoService {

	private ProcessoService facade = new Facade();

	@Override
	public void cadastraAplicacao(Aplicacao aplicacao) throws Exception {
		facade.cadastraAplicacao(aplicacao);
	}

	@Override
	public void cadastraCalendario(Calendario calendario) throws Exception {
		facade.cadastraCalendario(calendario);
	}

	@Override
	public void cadastraRegistroAplicacoes(RegistroAplicacoes registroAplicacoes) throws Exception {
		facade.cadastraRegistroAplicacoes(registroAplicacoes);
	}
	
	@Override
	public void cadastraVacina(Vacina vacina) throws Exception {
		facade.cadastraVacina(vacina);		
	}
	
	@Override
	public void cadastraUsuario(Usuario usuario) throws Exception {
		facade.cadastraUsuario(usuario);
	}

	@Override
	public Usuario doLogin(Usuario usuario) throws Exception {
		return facade.doLogin(usuario);
	}

	@Override
	public List<Aplicacao> getUsuarioAplicacoes(Usuario usuario) throws Exception {
		return facade.getUsuarioAplicacoes(usuario);
	}
	
}