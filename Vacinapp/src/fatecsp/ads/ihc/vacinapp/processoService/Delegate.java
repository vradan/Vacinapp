package fatecsp.ads.ihc.vacinapp.processoService;

import java.util.List;

import fatecsp.ads.ihc.vacinapp.composite.MinhasVacinasComposite;
import fatecsp.ads.ihc.vacinapp.entity.Aplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Calendario;
import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Unidade;
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
	public void cadastraRegistroAplicacoes(RegistroAplicacao registroAplicacoes) throws Exception {
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
	public List<MinhasVacinasComposite> getUsuarioAplicacoesComposite(Usuario usuario) throws Exception {
		return facade.getUsuarioAplicacoesComposite(usuario);
	}
	
	@Override
	public List<RegistroAplicacao> getRegistrosAplicacoesPendentes(Unidade unidade) throws Exception {
		return facade.getRegistrosAplicacoesPendentes(unidade);
	}

	@Override
	public void alteraDadosUsuario(Usuario usuario) throws Exception {
		facade.alteraDadosUsuario(usuario);
	}

	@Override
	public List<Unidade> getUnidades() throws Exception {
		return facade.getUnidades();
	}

	@Override
	public void registraAplicacao(RegistroAplicacao registro) throws Exception {
		facade.registraAplicacao(registro);
	}

	@Override
	public void deleteRegistroAplicacoes(RegistroAplicacao registro) throws Exception {
		facade.deleteRegistroAplicacoes(registro);
	}

	@Override
	public List<Vacina> getVacinas() throws Exception {
		return facade.getVacinas();
	}

	@Override
	public void deleteUsuario(Usuario usuario) throws Exception {
		facade.deleteUsuario(usuario);
	}

	@Override
	public RegistroAplicacao getRegistroByAplicacaoAndUserID(int usuarioID, int aplicacaoID) throws Exception {
		return facade.getRegistroByAplicacaoAndUserID(usuarioID, aplicacaoID);
	}

}