package fatecsp.ads.ihc.vacinapp.processoService.dao;

import java.util.List;

import fatecsp.ads.ihc.vacinapp.entity.Vacina;

public interface VacinaService {

	public void cadastraVacina(Vacina vacina) throws Exception;

	public void removeVacina(Vacina vacina) throws Exception;
	
	public void atualizaVacina(Vacina vacina) throws Exception;

	public Vacina getVacinaByID(int vacinaID) throws Exception;

	public List<Vacina> getVacinas() throws Exception;
	
}
