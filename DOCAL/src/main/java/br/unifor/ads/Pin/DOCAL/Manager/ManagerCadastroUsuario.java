package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL.controller.Controller;
import br.unifor.ads.DOCAL_core.entity.Usuario;
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

	public void btnCadastrarPressionado(String nome, String login,
			String senha, String altura, String peso) {
		Usuario user = createUsuario(nome, login, senha, altura, peso);
		controller.registerUsuario(user);
		controller.showLogin();
		tela.limparFormularios();
	}

	public void btnLimparPressionado() {
		tela.limparFormularios();
	}

	public Usuario createUsuario(String nome, String login,
			String senha, String altura, String peso) {
		Float alturaNum = Float.parseFloat(altura);
		Float pesoNum = Float.parseFloat(peso);
		Usuario user = new Usuario(nome, login, senha, alturaNum, pesoNum);
		return user;
	}

}
