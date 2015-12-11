package fatecsp.ads.ihc.vacinapp.processoService.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import fatecsp.ads.ihc.vacinapp.entity.Unidade;
import fatecsp.ads.ihc.vacinapp.utils.HibernateUtils;

public class LocalDAO extends HibernateDAO implements LocalService {

	@Override
	public List<Unidade> getUnidades() throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		String sql = "SELECT U "
				+ "		FROM Unidade U ";
		
		Query query = entityManager.createQuery(sql);
		
		try {
			
			List<?> results = query.getResultList();
			
			if (!results.isEmpty()) {
				
				List<Unidade> unidades = new ArrayList<Unidade>();
				
				for (Object obj : results) {
					unidades.add((Unidade) obj);
				}
				
				return unidades;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
