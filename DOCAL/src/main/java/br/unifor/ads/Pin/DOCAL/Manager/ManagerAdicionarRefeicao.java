package br.unifor.ads.Pin.DOCAL.Manager;

import javax.swing.JOptionPane;

import br.unifor.ads.DOCAL.controller.Controller;
import br.unifor.ads.DOCAL_core.entity.Refeicao;
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
		tela.loadRefeicaoData(controller.getLoggedUser());
		tela.limparForms();
		tela.pesquisa();
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

	public void btnRemoverPressionado(Refeicao ref, Integer row) {
		int op = JOptionPane.showConfirmDialog(controller.getFrame(),
				"Deseja remover esta refeicao da lista?", "Remover",
				JOptionPane.YES_NO_OPTION);
		if (op == 0) {
			controller.removeRefeicao(ref);
			tela.removeRefeicaoFromTable(row);
		}
	}

}
