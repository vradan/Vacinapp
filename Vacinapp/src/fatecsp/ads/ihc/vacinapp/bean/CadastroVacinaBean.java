package fatecsp.ads.ihc.vacinapp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fatecsp.ads.ihc.vacinapp.entity.Vacina;
import fatecsp.ads.ihc.vacinapp.processoService.Delegate;
import fatecsp.ads.ihc.vacinapp.processoService.ProcessoService;

@ManagedBean(name = "cadastroVacina")
@RequestScoped
public class CadastroVacinaBean {

	private ProcessoService delegate = new Delegate();
	
	private Vacina vacina;
	
	public CadastroVacinaBean() {
		vacina = new Vacina();
		
		vacina.setNome("HPV");
		vacina.setObrigatoria(true);
		
		try {
			delegate.cadastraVacina(vacina);
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar vacina");
			e.printStackTrace();
		}
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	
}
