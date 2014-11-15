package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL_core.business.BusinessCadastroDieta;
import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.DOCAL_core.entity.Usuario;
import br.unifor.ads.Pin.DOCAL.Telas.PopUpper;
import br.unifor.ads.Pin.DOCAL.Telas.TelaCadastroDieta;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre
 * TelaCadastroDieta e o resto da aplicacao.
 */
public class ManagerCadastroDieta {

	private FrameController controller;
	private TelaCadastroDieta tela;
	private BusinessCadastroDieta business;
	private PopUpper popUp;

	public ManagerCadastroDieta(FrameController controller) {
		this.controller = controller;
		this.tela = new TelaCadastroDieta(this);
		business = new BusinessCadastroDieta();
		popUp = new PopUpper();
	}

	public TelaCadastroDieta getTela() {
		return tela;
	}

	public void btnCadastrarPressionado(String nome, String carb, String prot,
			String gord) {
		Dieta dieta = createDieta(nome, carb, prot, gord);
		if (dieta != null) {
			business.registerDieta(dieta);
			controller.showHome();
		}
		tela.limparFormularios();
	}

	public void btnCancelarPressionado() {
		controller.showHome();
		tela.limparFormularios();
	}

	public Dieta createDieta(String nome, String carb, String prot, String gord) {
		try {
			Float carbNum = Float.parseFloat(carb);
			Float protNum = Float.parseFloat(prot);
			Float gordNum = Float.parseFloat(gord);
			Usuario user = business.getLoggedUser();
			Dieta dieta = new Dieta(user, nome, carbNum, protNum, gordNum);
			return dieta;
		} catch (NumberFormatException e) {
			popUp.show("Valores invalidos.");
			return null;
		}
	}

}
