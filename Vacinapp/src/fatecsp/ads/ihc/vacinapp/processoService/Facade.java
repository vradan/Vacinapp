package fatecsp.ads.ihc.vacinapp.processoService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fatecsp.ads.ihc.vacinapp.composite.AplicacaoComposite;
import fatecsp.ads.ihc.vacinapp.composite.MinhasVacinasComposite;
import fatecsp.ads.ihc.vacinapp.entity.Aplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Calendario;
import fatecsp.ads.ihc.vacinapp.entity.RegistroAplicacao;
import fatecsp.ads.ihc.vacinapp.entity.Unidade;
import fatecsp.ads.ihc.vacinapp.entity.Usuario;
import fatecsp.ads.ihc.vacinapp.entity.Vacina;
import fatecsp.ads.ihc.vacinapp.exception.UsuarioNotFoundException;
import fatecsp.ads.ihc.vacinapp.processoService.dao.AplicacaoService;
import fatecsp.ads.ihc.vacinapp.processoService.dao.CalendarioService;
import fatecsp.ads.ihc.vacinapp.processoService.dao.LocalService;
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
	private LocalService localDAO = factory.getInstanceLocalDAO();
	
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
	public void cadastraRegistroAplicacoes(RegistroAplicacao registroAplicacoes) throws Exception {
		registroAplicacoesDAO.cadastraRegistroAplicacoes(registroAplicacoes);
	}
	
	@Override
	public void cadastraVacina(Vacina vacina) throws Exception {
		vacinaDAO.cadastraVacina(vacina);
	}
	
	@Override
	public void cadastraUsuario(Usuario usuario) throws Exception {
		try {
			usuarioDAO.getUsuarioByEmail(usuario.getEmail());
			throw new Exception("Já existe um usuário com este email!");
		} catch (UsuarioNotFoundException e) {
			usuarioDAO.cadastraUsuario(usuario);
		}
	}

	@Override
	public Usuario doLogin(Usuario usuario) throws Exception {
		
		Usuario usuarioLogado = usuarioDAO.getUsuarioByEmail(usuario.getEmail());
		
		if (usuario.getPassword().equals(usuarioLogado.getPassword())) {
			return usuarioLogado;
		} else {
			throw new Exception("Senha inválida!");
		}
	}

	@Override
	public List<MinhasVacinasComposite> getUsuarioAplicacoesComposite(Usuario usuario) throws Exception {
		List<RegistroAplicacao> registros;
		List<Calendario> calendarios;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(usuario.getDataNascimento());
		
		LocalDate now = LocalDate.now();
		LocalDate nascimento = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
		
		Period p = Period.between(nascimento, now);
		
		registros = registroAplicacoesDAO.getRegistrosAplicacoesByUser(usuario);
		calendarios = calendarioDAO.getCalendarioBeforeMonthAndSexo(p.getMonths() + (p.getYears()*12), usuario.getSexo());
		
		List<MinhasVacinasComposite> minhasVacinasComposites = new ArrayList<MinhasVacinasComposite>();

		for (Calendario calendario : calendarios) {
			MinhasVacinasComposite minhasVacinasComposite = new MinhasVacinasComposite();
			
			List<Aplicacao> aplicacoesAux = aplicacaoDAO.getAplicacoesByCalendario(calendario);
			
			if (aplicacoesAux != null && !aplicacoesAux.isEmpty()) {
				List<AplicacaoComposite> aplicacoesComposite = new ArrayList<AplicacaoComposite>();
				for (Aplicacao aplicacao : aplicacoesAux) {
					AplicacaoComposite aplicacaoComposite = new AplicacaoComposite();
					boolean aplicada = false;
					boolean aprovada = false;
					
					if (registros != null) {
						for (RegistroAplicacao registro : registros) {
							if (aplicacao.getId() == registro.getAplicacao().getId()) {
								aplicada = true;
								aprovada = registro.getAprovada();
								break;
							}
						}
					}
					aplicacaoComposite.setAplicada(aplicada);
					aplicacaoComposite.setAprovada(aprovada);
					aplicacaoComposite.setAplicacao(aplicacao);
					
					boolean alreadyExist = false;
					int index = 0;
					for (AplicacaoComposite aplicacaoCompositeAux : aplicacoesComposite) {
						if (aplicacaoComposite.getAplicacao().getVacina().getId() == aplicacaoCompositeAux.getAplicacao().getVacina().getId()) {
							if (!aplicacaoComposite.getAprovada() && !aplicacaoCompositeAux.getAprovada()) {
								alreadyExist = true;
								break;
							}
						}
						index++;
					}
					
					if (!alreadyExist) {
						aplicacoesComposite.add(aplicacaoComposite);
					} else {
						aplicacoesComposite.get(index).setDoses(aplicacoesComposite.get(index).getDoses() + 1);
					}
				}
				minhasVacinasComposite.setCalendario(calendario);
				minhasVacinasComposite.setAplicacoesComposite(aplicacoesComposite);
				minhasVacinasComposites.add(minhasVacinasComposite);
			}
		}
		
		return minhasVacinasComposites;
	}

	@Override
	public void alteraDadosUsuario(Usuario usuario) throws Exception {
		usuarioDAO.atualizaUsuario(usuario);
	}

	@Override
	public List<Unidade> getUnidades() throws Exception {
		return localDAO.getUnidades();
	}
	
	@Override
	public List<RegistroAplicacao> getRegistrosAplicacoesPendentes(Unidade unidade) throws Exception {
		return registroAplicacoesDAO.getRegistrosAplicacoesPendentes(unidade);
	}

	@Override
	public void registraAplicacao(RegistroAplicacao registro) throws Exception {
		registroAplicacoesDAO.atualizaRegistroAplicacoes(registro);
	}

	@Override
	public void deleteRegistroAplicacoes(RegistroAplicacao registro) throws Exception {
		registroAplicacoesDAO.removeRegistroAplicacoes(registro);
	}

	@Override
	public List<Vacina> getVacinas() throws Exception {
		return vacinaDAO.getVacinas();
	}

	@Override
	public void deleteUsuario(Usuario usuario) throws Exception {
		usuarioDAO.removeUsuario(usuario);
	}

	@Override
	public RegistroAplicacao getRegistroByAplicacaoAndUserID(int usuarioID, int aplicacaoID) throws Exception {
		return registroAplicacoesDAO.getRegistroByAplicacaoAndUserID(usuarioID, aplicacaoID);
	}

}
