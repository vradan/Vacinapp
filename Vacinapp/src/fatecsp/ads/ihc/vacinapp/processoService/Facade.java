package fatecsp.ads.ihc.vacinapp.processoService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fatecsp.ads.ihc.vacinapp.entity.Aplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Calendario;
import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacoes;
import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.Vacina;
import fatecsp.ads.ihc.vacinapp.exception.UsuarioNotFoundException;
import fatecsp.ads.ihc.vacinapp.processoService.dao.AplicacaoService;
import fatecsp.ads.ihc.vacinapp.processoService.dao.CalendarioService;
import fatecsp.ads.ihc.vacinapp.processoService.dao.RegistroAplicacoesService;
import fatecsp.ads.ihc.vacinapp.processoService.dao.UsuarioService;
import fatecsp.ads.ihc.vacinapp.processoService.dao.VacinaService;

public class Facade implements ProcessoService {

	private static Factory factory = new Factory();

	private AplicacaoService aplicacaoDAO = factory.getInstanceAplicacaoDAO();
	private CalendarioService calendarioDAO = factory.getInstanceCalendarioDAO();
	private RegistroAplicacoesService registroAplicacoesDAO = factory.getInstanceRegistroAplicacoesDAO();
	private VacinaService vacinaDAO = factory.getInstanceVacinaDAO();
	private UsuarioService usuarioDAO = factory.getInstanceUsuarioDAO();
	
	public Facade() {
		if (factory == null)
			factory = new Factory();
	}
	
	@Override
	public void cadastraAplicacao(Aplicacao aplicacao) throws Exception {
		aplicacaoDAO.cadastraAplicacao(aplicacao);
	}
	
	@Override
	public void cadastraCalendario(Calendario calendario) throws Exception {
		calendarioDAO.cadastraCalendario(calendario);
	}
	
	@Override
	public void cadastraRegistroAplicacoes(RegistroAplicacoes registroAplicacoes) throws Exception {
		registroAplicacoesDAO.cadastraRegistroAplicacoes(registroAplicacoes);
	}
	
	@Override
	public void cadastraVacina(Vacina vacina) throws Exception {
		vacinaDAO.cadastraVacina(vacina);
	}
	
	@Override
	public void cadastraUsuario(Usuario usuario) throws Exception {
		try {
			usuarioDAO.getUsuarioByEmail(usuario);
			throw new Exception("Já existe um usuário com este email!");
		} catch (UsuarioNotFoundException e) {
			usuarioDAO.cadastraUsuario(usuario);
		}
	}

	@Override
	public Usuario doLogin(Usuario usuario) throws Exception {
		
		Usuario usuarioLogado = usuarioDAO.getUsuarioByEmail(usuario);
		
		if (usuario.getPassword().equals(usuarioLogado.getPassword())) {
			return usuarioLogado;
		} else {
			throw new Exception("Senha inválida!");
		}
	}

	@Override
	public List<Aplicacao> getUsuarioAplicacoes(Usuario usuario) throws Exception {
		List<Aplicacao> aplicacoes = new ArrayList<Aplicacao>();
		List<Calendario> calendarios;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(usuario.getDataNascimento());
		
		LocalDate now = LocalDate.now();
		LocalDate nascimento = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
		
		Period p = Period.between(nascimento, now);
		
		calendarios = calendarioDAO.getCalendarioBetweenMonthAndSexo(p.getMonths() + (p.getYears()*12), usuario.getSexo());
		
		for (Calendario calendario : calendarios) {
			for (Aplicacao aplicacao : aplicacaoDAO.getAplicacoesByCalendario(calendario)) {
				aplicacoes.add(aplicacao);
			}
		}
		
		return aplicacoes;
	}

}
