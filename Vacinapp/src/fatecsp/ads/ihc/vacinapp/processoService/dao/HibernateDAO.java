package fatecsp.ads.ihc.vacinapp.processoService.dao;

import javax.persistence.EntityManager;

import fatecsp.ads.ihc.vacinapp.utils.HibernateUtils;

public class HibernateDAO implements HibernateService {
	
	EntityManager entityManager;
	
	@Override
	public void persist(Object obj) throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(obj);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public void merge(Object obj) throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(obj);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		} finally {
			entityManager.close();
		}
	}
	
}
