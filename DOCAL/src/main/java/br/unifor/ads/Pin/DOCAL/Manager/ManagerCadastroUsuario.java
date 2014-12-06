package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL_core.business.BusinessCadastroUsuario;
import br.unifor.ads.DOCAL_core.entity.Usuario;
import br.unifor.ads.Pin.DOCAL.Telas.PopUpper;
import br.unifor.ads.Pin.DOCAL.Telas.TelaCadastroUsuario;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre
 * TelaCadastroUsuario e o resto da aplicacao.
 */
public class ManagerCadastroUsuario {

	private FrameController controller;
	private TelaCadastroUsuario tela;
	private BusinessCadastroUsuario business;
	private PopUpper popUp;

	public ManagerCadastroUsuario(FrameController controller) {
		this.controller = controller;
		tela = new TelaCadastroUsuario(this);
		popUp = new PopUpper();
		business = new BusinessCadastroUsuario();
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
		if (user != null) {
			tryRegisterUsuario(user);
		}
		tela.limparFormularios();
	}

	public Usuario createUsuario(String nome, String login, String senha,
			String altura, String peso) {
		try {
			Float alturaNum = Float.parseFloat(altura);
			Float pesoNum = Float.parseFloat(peso);
			Usuario user = new Usuario(nome, login, senha, alturaNum, pesoNum);
			return user;
		} catch (NumberFormatException e) {
			popUp.show("Valores invalidos.");
			return null;
		}
	}

	private void tryRegisterUsuario(Usuario user) {
		if (business.registerUsuario(user)) {
			popUp.show("Usuario cadastrado com sucesso!");
			controller.showLogin();
		} else {
			popUp.show("Esse login ja esta sendo usado. Por favor digite escolha um login diferente.");
		}
	}

	public void btnLimparPressionado() {
		tela.limparFormularios();
	}

}
