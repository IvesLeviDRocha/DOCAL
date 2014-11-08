package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL.controller.Controller;
import br.unifor.ads.Pin.DOCAL.Telas.TelaCadastroUsuario;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre
 * TelaCadastroUsuario e o resto da aplicacao.
 */
public class ManagerCadastroUsuario {

	private Controller controller;
	private TelaCadastroUsuario tela;

	public ManagerCadastroUsuario(Controller controller) {
		this.controller = controller;
		this.tela = new TelaCadastroUsuario(this);
	}

	public TelaCadastroUsuario getTela() {
		return tela;
	}

	public void btnCancelarPressionado() {
		controller.showLogin();
		tela.limparFormularios();
	}

	public void btnCadastrarPressionado() {
		controller.showHome();
		tela.limparFormularios();
	}

	public void btnLimparPressionado() {
		tela.limparFormularios();
	}

}
