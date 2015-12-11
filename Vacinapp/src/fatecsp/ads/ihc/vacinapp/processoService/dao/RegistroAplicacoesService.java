package fatecsp.ads.ihc.vacinapp.processoService.dao;

import java.util.List;

import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Unidade;
import fatecsp.ads.ihc.vacinapp.entity.Usuario;

public interface RegistroAplicacoesService {
	
	public void cadastraRegistroAplicacoes(RegistroAplicacao registroAplicacoes) throws Exception;
	
	public void removeRegistroAplicacoes(RegistroAplicacao registroAplicacoes) throws Exception;
	
	public void atualizaRegistroAplicacoes(RegistroAplicacao registroAplicacoes) throws Exception;

	public List<RegistroAplicacao> getRegistrosAplicacoesPendentes(Unidade unidade) throws Exception;

	public List<RegistroAplicacao> getRegistrosAplicacoesByUser(Usuario usuario) throws Exception;

	public RegistroAplicacao getRegistroByAplicacaoAndUserID(int usuarioID, int aplicacaoID) throws Exception;

}
