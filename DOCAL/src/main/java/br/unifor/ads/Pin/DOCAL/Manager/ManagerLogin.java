package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL.controller.Controller;
import br.unifor.ads.Pin.DOCAL.Telas.TelaLogin;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre TelaLogin e o
 * resto da aplicacao.
 */
public class ManagerLogin {

	private Controller controller;
	private TelaLogin tela;

	public ManagerLogin(Controller controller) {
		this.controller = controller;
		this.tela = new TelaLogin(this);
	}

	public TelaLogin getTela() {
		return tela;
	}

	public void btnEntrarPressionado() {
		controller.showHome();
		tela.limparFormularios();
	}

	public void lblCadastrarPressionado() {
		controller.showCadastroUsuario();
		tela.limparFormularios();
	}

	public void btnSairPressionado() {
		controller.sair();
	}

}
