package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL_core.business.BusinessLogin;
import br.unifor.ads.Pin.DOCAL.Telas.PopUpper;
import br.unifor.ads.Pin.DOCAL.Telas.TelaLogin;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre TelaLogin e o
 * resto da aplicacao.
 */
public class ManagerLogin {

	private FrameController controller;
	private TelaLogin tela;
	private BusinessLogin business;
	private PopUpper popUp;

	public ManagerLogin(FrameController controller) {
		this.controller = controller;
		this.tela = new TelaLogin(this);
		this.business = new BusinessLogin();
	}

	public TelaLogin getTela() {
		return tela;
	}

	public void btnEntrarPressionado(String login, String senha) {
		if (business.logUser(login, senha)) {
			controller.showHome();
			tela.clearFields();
		} else {
			popUp.show("Usuario ou senha incorretos");
		}
	}

	public void lblCadastrarPressionado() {
		controller.showCadastroUsuario();
		tela.clearFields();
	}

	public void btnSairPressionado() {
		controller.sair();
	}

}
