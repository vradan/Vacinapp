package fatecsp.ads.ihc.vacinapp.processoService;

import java.util.List;

import fatecsp.ads.ihc.vacinapp.composite.MinhasVacinasComposite;
import fatecsp.ads.ihc.vacinapp.entity.Aplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Calendario;
import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Unidade;
import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.Vacina;

public interface ProcessoService {

	public void cadastraAplicacao(Aplicacao aplicacao) throws Exception;

	public void cadastraCalendario(Calendario calendario) throws Exception;
	
	public void cadastraRegistroAplicacoes(RegistroAplicacao registroAplicacoes) throws Exception;
	
	public void cadastraVacina(Vacina vacina) throws Exception;
	
	public void cadastraUsuario(Usuario usuario) throws Exception;

	public Usuario doLogin(Usuario usuario) throws Exception;

	public List<MinhasVacinasComposite> getUsuarioAplicacoesComposite(Usuario usuario) throws Exception;
	
	public List<Unidade> getUnidades() throws Exception;
	
	public List<RegistroAplicacao> getRegistrosAplicacoesPendentes(Unidade unidade) throws Exception;

	public void alteraDadosUsuario(Usuario usuario) throws Exception;

	public void registraAplicacao(RegistroAplicacao registro) throws Exception;

	public void deleteRegistroAplicacoes(RegistroAplicacao registro) throws Exception;
	
	public List<Vacina> getVacinas() throws Exception;

	public void deleteUsuario(Usuario usuario) throws Exception;

	public RegistroAplicacao getRegistroByAplicacaoAndUserID(int usuarioID, int aplicacaoID) throws Exception;
	
}
