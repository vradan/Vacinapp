package fatecsp.ads.ihc.vacinapp.processoService;

import java.util.List;

import fatecsp.ads.ihc.vacinapp.entity.Aplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Calendario;
import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacoes;
import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.Vacina;

public interface ProcessoService {

	public void cadastraAplicacao(Aplicacao aplicacao) throws Exception;

	public void cadastraCalendario(Calendario calendario) throws Exception;
	
	public void cadastraRegistroAplicacoes(RegistroAplicacoes registroAplicacoes) throws Exception;
	
	public void cadastraVacina(Vacina vacina) throws Exception;
	
	public void cadastraUsuario(Usuario usuario) throws Exception;

	public Usuario doLogin(Usuario usuario) throws Exception;

	public List<Aplicacao> getUsuarioAplicacoes(Usuario usuario) throws Exception;
	
}
