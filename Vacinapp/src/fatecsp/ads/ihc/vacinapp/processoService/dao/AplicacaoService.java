package fatecsp.ads.ihc.vacinapp.processoService.dao;

import java.util.List;

import fatecsp.ads.ihc.vacinapp.entity.Aplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Calendario;

public interface AplicacaoService {
	
	public void cadastraAplicacao(Aplicacao aplicacao) throws Exception;
	
	public void removeAplicacao(Aplicacao aplicacao) throws Exception;
	
	public void atualizaAplicacao(Aplicacao aplicacao) throws Exception;

	public List<Aplicacao> getAplicacoesByCalendario(Calendario calendario) throws Exception;

}
