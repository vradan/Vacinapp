package fatecsp.ads.ihc.vacinapp.processoService.dao;

import java.util.List;

import fatecsp.ads.ihc.vacinapp.entity.Unidade;

public interface LocalService {

	public List<Unidade> getUnidades() throws Exception;
	
}
