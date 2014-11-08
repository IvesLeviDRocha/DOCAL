package br.unifor.ads.Pin.DOCAL.Manager;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.unifor.ads.DOCAL.controller.Controller;
import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.Pin.DOCAL.Telas.TelaHome;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre TelaHome e o
 * resto da aplicacao.
 */
public class ManagerHome {

	private Controller controller;
	private TelaHome tela;

	private String[][] dados = { { "Caboidratos", "Valor", "Valor" },
			{ "Proteinas", "Valor", "Valor" },
			{ "Gorduras", "Valor", "Valor" },
			{ "Calorias Totais", "Valor", "Valor" } };

	public ManagerHome(Controller controller) {
		this.controller = controller;
		this.tela = new TelaHome(this);
	}

	public TelaHome getTela() {
		return tela;
	}

	public void btnAddRefeicaoPressionado() {
		controller.showAdicionarRefeicao();

	}

	public void btnResetPressionado() {
		JOptionPane.showConfirmDialog(controller.getFrame(),
				"Deseja resetar a contagem atual?", "Reset",
				JOptionPane.YES_NO_OPTION);
	}

	public void btnNovaDietaPressionado() {
		controller.showCadastroDieta();

	}

	public void btnSairPressionado() {
		int op = JOptionPane.showConfirmDialog(controller.getFrame(), "Sair?",
				"Sair", JOptionPane.YES_NO_OPTION);
		switch (op) {
		case 0:
			controller.showLogin();
			break;
		default:
			break;
		}

	}

	public void btnAtualizarDadosPressionado() {
		JOptionPane.showInputDialog(controller.getFrame(),
				"Digite nova altura:");
		JOptionPane.showInputDialog(controller.getFrame(), "Digite novo peso:");
		JOptionPane.showMessageDialog(controller.getFrame(),
				"Dados atualizados.");
	}

	public void updateTableDieta(Dieta dieta) {
		dados[0][1] = String.valueOf(dieta.getCarboidratos());
		dados[1][1] = String.valueOf(dieta.getProteinas());
		dados[2][1] = String.valueOf(dieta.getGorduras());
		tela.refreshTable();
	}

	public String[][] getDados() {
		return dados;
	}
}
