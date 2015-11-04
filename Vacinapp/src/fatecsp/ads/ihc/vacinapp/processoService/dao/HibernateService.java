package fatecsp.ads.ihc.vacinapp.processoService.dao;

public interface HibernateService {

	public void persist(Object obj) throws Exception;
	
	public void merge(Object obj) throws Exception;
	
}
