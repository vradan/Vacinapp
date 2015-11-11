package fatecsp.ads.ihc.vacinapp.processoService.dao;

import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacoes;

public class RegistroAplicacoesDAO extends HibernateDAO implements RegistroAplicacoesService {

	@Override
	public void cadastraRegistroAplicacoes(RegistroAplicacoes registroAplicacoes) throws Exception {
		persist(registroAplicacoes);
	}

	@Override
	public void removeRegistroAplicacoes(RegistroAplicacoes registroAplicacoes) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void atualizaRegistroAplicacoes(RegistroAplicacoes registroAplicacoes) throws Exception {
		// TODO Auto-generated method stub
	}

}
