package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL.controller.Controller;
import br.unifor.ads.Pin.DOCAL.Telas.TelaCadastroRefeicao;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre
 * TelaCadastroRefeicao e o resto da aplicacao.
 */
public class ManagerCadastroRefeicao {

	private Controller controller;
	private TelaCadastroRefeicao tela;

	public ManagerCadastroRefeicao(Controller controller) {
		this.controller = controller;
		this.tela = new TelaCadastroRefeicao(this);
	}

	public void btnCadastrarPressionado() {
		controller.showAdicionarRefeicao();
		tela.limparFormularios();
	}

	public void btnCancelarPressionado() {
		controller.showAdicionarRefeicao();
		tela.limparFormularios();
	}

	public TelaCadastroRefeicao getTela() {
		return tela;
	}

}
