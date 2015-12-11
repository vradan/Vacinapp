package fatecsp.ads.ihc.vacinapp.processoService.dao;

import java.util.List;

import fatecsp.ads.ihc.vacinapp.entity.Calendario;
import fatecsp.ads.ihc.vacinapp.entity.constants.Sexo;

public interface CalendarioService {
	
	public void cadastraCalendario(Calendario calendario) throws Exception;
	
	public void removeCalendario(Calendario calendario) throws Exception;

	public void atualizaCalendario(Calendario calendario) throws Exception;

	public List<Calendario> getCalendarioBeforeMonthAndSexo(int month, Sexo sexo) throws Exception;

}
