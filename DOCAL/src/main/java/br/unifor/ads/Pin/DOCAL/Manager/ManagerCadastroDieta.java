package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL.controller.Controller;
import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.DOCAL_core.entity.Usuario;
import br.unifor.ads.Pin.DOCAL.Telas.TelaCadastroDieta;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre
 * TelaCadastroDieta e o resto da aplicacao.
 */
public class ManagerCadastroDieta {

	private Controller controller;
	private TelaCadastroDieta tela;

	public ManagerCadastroDieta(Controller controller) {
		this.controller = controller;
		this.tela = new TelaCadastroDieta(this);
	}

	public TelaCadastroDieta getTela() {
		return tela;
	}

	public void btnCadastrarPressionado(String nome, String carb, String prot,
			String gord) {
		Dieta dieta = createDieta(nome, carb, prot, gord);
		controller.registerDieta(dieta);
		controller.showHome();
		tela.limparFormularios();
	}

	public void btnCancelarPressionado() {
		controller.showHome();
		tela.limparFormularios();
	}

	public Dieta createDieta(String nome, String carb, String prot, String gord) {
		Float carbNum = Float.parseFloat(carb);
		Float protNum = Float.parseFloat(prot);
		Float gordNum = Float.parseFloat(gord);
		Usuario user = controller.getLoggedUser();
		Dieta dieta = new Dieta(user, nome, carbNum, protNum, gordNum);
		return dieta;
	}

}
