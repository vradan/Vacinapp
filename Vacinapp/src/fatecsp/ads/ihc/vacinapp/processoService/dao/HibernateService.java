package fatecsp.ads.ihc.vacinapp.processoService.dao;

public interface HibernateService {

	public void persist(Object obj) throws Exception;
	
	public void merge(Object obj) throws Exception;

	public void update(Object obj) throws Exception;

	public <T> void remove(Class<T> type, int id) throws Exception;
	
}
