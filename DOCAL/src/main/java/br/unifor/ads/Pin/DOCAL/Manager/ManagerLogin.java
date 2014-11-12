package br.unifor.ads.Pin.DOCAL.Manager;

import javax.swing.JOptionPane;

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

	public void btnEntrarPressionado(String login, String senha) {
		if (controller.logUser(login, senha)) {
			controller.showHome();
			tela.clearFields();
		} else {
			JOptionPane.showMessageDialog(tela, "Usuario ou senha incorretos");
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
