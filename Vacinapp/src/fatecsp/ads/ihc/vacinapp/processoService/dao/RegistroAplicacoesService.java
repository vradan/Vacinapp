package fatecsp.ads.ihc.vacinapp.processoService.dao;

import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacoes;

public interface RegistroAplicacoesService {
	
	public void cadastraRegistroAplicacoes(RegistroAplicacoes registroAplicacoes) throws Exception;
	
	public void removeRegistroAplicacoes(RegistroAplicacoes registroAplicacoes) throws Exception;
	
	public void atualizaRegistroAplicacoes(RegistroAplicacoes registroAplicacoes) throws Exception;

}
