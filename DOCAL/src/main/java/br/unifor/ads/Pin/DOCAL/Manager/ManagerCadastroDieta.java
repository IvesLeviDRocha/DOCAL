package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL.controller.Controller;
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

	public void btnCadastrarPressionado() {
		controller.showHome();
		tela.limparFormularios();
	}

	public void btnCancelarPressionado() {
		controller.showHome();
		tela.limparFormularios();
	}

}
