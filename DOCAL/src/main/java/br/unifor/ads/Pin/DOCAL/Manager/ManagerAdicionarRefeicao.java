package br.unifor.ads.Pin.DOCAL.Manager;

import javax.swing.JOptionPane;

import br.unifor.ads.DOCAL.controller.Controller;
import br.unifor.ads.Pin.DOCAL.Telas.TelaAdicionarRefeicao;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre
 * TelaAdicionarRefeicao e o resto da aplicacao.
 */
public class ManagerAdicionarRefeicao {

	private Controller controller;
	private TelaAdicionarRefeicao tela;

	public ManagerAdicionarRefeicao(Controller controller) {
		this.controller = controller;
		this.tela = new TelaAdicionarRefeicao(this);

	}

	public TelaAdicionarRefeicao getTela() {
		return tela;
	}

	public void btnAdicionarPressionado() {
		controller.showHome();
	}

	public void btnCadastrarNovaPressionado() {
		controller.showCadastroRefeicao();

	}

	public void btnCancelarPressionado() {
		controller.showHome();

	}

	public void btnRemoverPressionado() {
		JOptionPane.showConfirmDialog(controller.getFrame(),
				"Deseja remover esta refeicao da lista?", "Remover",
				JOptionPane.YES_NO_OPTION);
	}

}
