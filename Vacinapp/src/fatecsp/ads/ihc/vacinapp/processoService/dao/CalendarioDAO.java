package fatecsp.ads.ihc.vacinapp.processoService.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import fatecsp.ads.ihc.vacinapp.entity.Calendario;
import fatecsp.ads.ihc.vacinapp.entity.constants.Sexo;
import fatecsp.ads.ihc.vacinapp.utils.HibernateUtils;

public class CalendarioDAO extends HibernateDAO implements CalendarioService {

	@Override
	public void cadastraCalendario(Calendario calendario) throws Exception {
		persist(calendario);
	}
	
	@Override
	public void removeCalendario(Calendario calendario) throws Exception {
		//TODO
	}
	
	@Override
	public void atualizaCalendario(Calendario calendario) throws Exception {
		//TODO
	}

	@Override
	public List<Calendario> getCalendarioBeforeMonthAndSexo(int month, Sexo sexo) throws Exception {
		entityManager = HibernateUtils.getEntityManager();
		
		String sql = "SELECT C "
				+ "		FROM Calendario C "
				+ "		WHERE C.faixaInicio <= :month "
				+ "			AND (C.sexo = 'A' OR C.sexo = '" + sexo.getSexo() + "') ";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("month", month);
		
		try {
			
			List<?> results = query.getResultList();
			
			if (!results.isEmpty()) {
				
				List<Calendario> calendarios = new ArrayList<Calendario>();
				
				for (Object obj : results) {
					calendarios.add((Calendario) obj);
				}
				
				return calendarios;
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
