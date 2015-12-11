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
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
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
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			throw e;
		} finally {
			entityManager.close();
		}
	}
	
	@Override
	public void update(Object obj) throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(obj);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public <T> void remove(Class<T> type, int id) throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			Object obj = entityManager.find(type, id);
			entityManager.remove(obj);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			throw e;
		} finally {
			entityManager.close();
		}
	}
	
	
}
