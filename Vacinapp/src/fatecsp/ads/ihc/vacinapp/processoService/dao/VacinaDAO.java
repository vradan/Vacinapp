package fatecsp.ads.ihc.vacinapp.processoService.dao;

import fatecsp.ads.ihc.vacinapp.entity.Vacina;

public class VacinaDAO extends HibernateDAO implements VacinaService {

	@Override
	public void cadastraVacina(Vacina vacina) throws Exception {
		persist(vacina);
	}
	
	@Override
	public void removeVacina(Vacina vacina) throws Exception {
		//TODO
	}
	
	@Override
	public void atualizaVacina(Vacina vacina) throws Exception {
		//TODO
	}

}
