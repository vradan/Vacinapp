package fatecsp.ads.ihc.vacinapp.processoService.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import fatecsp.ads.ihc.vacinapp.entity.Vacina;
import fatecsp.ads.ihc.vacinapp.utils.HibernateUtils;

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

	@Override
	public Vacina getVacinaByID(int vacinaID) throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		String sql = "  SELECT V FROM Vacina V"
				+ "		WHERE  V.id_vacina = :id ";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", vacinaID);
		
		try {
			if (!query.getResultList().isEmpty()) {
				return (Vacina) query.getResultList().get(0);
			}
			throw new Exception("Vacina não econtrada!");
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Vacina> getVacinas() throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		String sql = "SELECT V FROM Vacina V ";
		
		Query query = entityManager.createQuery(sql);
		
		try {
			
			List<?> results = query.getResultList();
			
			if (!results.isEmpty()) {
				
				List<Vacina> vacinas = new ArrayList<Vacina>();
				
				for (Object obj : results) {
					vacinas.add((Vacina) obj);
				}
				
				return vacinas;
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
