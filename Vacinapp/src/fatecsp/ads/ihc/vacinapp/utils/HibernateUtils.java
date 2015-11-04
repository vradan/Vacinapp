package fatecsp.ads.ihc.vacinapp.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {

	private static EntityManagerFactory factory;
	
	public static EntityManager getEntityManager() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("Vacinapp");
		}
		
		return factory.createEntityManager();
	}
	
}
