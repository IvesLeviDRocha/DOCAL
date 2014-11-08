package br.unifor.ads.Pin.DOCAL.Manager;

import javax.swing.JOptionPane;

import br.unifor.ads.DOCAL.controller.Controller;
import br.unifor.ads.DOCAL_core.dao.DietaDAO;
import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.DOCAL_core.entity.Usuario;
import br.unifor.ads.Pin.DOCAL.Telas.TelaHome;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre TelaHome e o
 * resto da aplicacao.
 */
public class ManagerHome {

	private Controller controller;
	private TelaHome tela;

	public ManagerHome(Controller controller) {
		this.controller = controller;
		this.tela = new TelaHome(this);
	}

	public TelaHome getTela() {
		Usuario loggedUser = controller.getLoggedUser();
		Dieta userDiet = DietaDAO.findByUsuarioId(loggedUser.getId());
		if (userDiet == null) {
			JOptionPane.showMessageDialog(tela,
					"Você não possui nenhuma dieta cadastrada.");
			tela.updateUserName(loggedUser.getNome());
		} else {
			tela.updateUserData(loggedUser.getNome(), userDiet);
		}
		return tela;
	}

	public void btnAddRefeicaoPressionado() {
		controller.showAdicionarRefeicao();

	}

	public void btnResetPressionado() {
		JOptionPane.showConfirmDialog(tela, "Deseja resetar a contagem atual?",
				"Reset", JOptionPane.YES_NO_OPTION);
	}

	public void btnNovaDietaPressionado() {
		controller.showCadastroDieta();
	}

	public void btnSairPressionado() {
		int op = JOptionPane.showConfirmDialog(tela, "Sair?", "Sair",
				JOptionPane.YES_NO_OPTION);
		switch (op) {
		case 0:
			controller.showLogin();
			break;
		default:
			break;
		}

	}

	public void btnAtualizarDadosPressionado() {
		JOptionPane.showInputDialog(tela, "Digite nova altura:");
		JOptionPane.showInputDialog(tela, "Digite novo peso:");
		JOptionPane.showMessageDialog(tela, "Dados atualizados.");
	}

}
