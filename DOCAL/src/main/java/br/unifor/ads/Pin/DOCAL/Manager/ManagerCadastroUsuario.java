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
		System.out.println("step1");
		if (business.registerUsuario(user)) {
			System.out.println("step2");
			popUp.show("Usuario cadastrado com sucesso!");
			System.out.println("step3");
			controller.showLogin();
			System.out.println("step4");
		} else {
			System.out.println("step5");
			popUp.show("Esse login ja esta sendo usado. Por favor digite escolha um login diferente.");
			System.out.println("step6");
		}
		System.out.println("step7");
	}

	public void btnLimparPressionado() {
		tela.limparFormularios();
	}

}
