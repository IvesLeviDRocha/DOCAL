package br.unifor.ads.Pin.DOCAL.Manager;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.unifor.ads.DOCAL.controller.Controller;
import br.unifor.ads.DOCAL_core.dao.DietaDAO;
import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.DOCAL_core.entity.Refeicao;
import br.unifor.ads.DOCAL_core.entity.Usuario;
import br.unifor.ads.Pin.DOCAL.Telas.TelaHome;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre TelaHome e o
 * resto da aplicacao.
 */
public class ManagerHome {

	private Controller controller;
	private TelaHome tela;

	private List<Refeicao> addedRefeicoes;

	public ManagerHome(Controller controller) {
		this.controller = controller;
		this.tela = new TelaHome(this);
		addedRefeicoes = new ArrayList<Refeicao>();
	}

	public void addRefeicao(Refeicao ref) {
		addedRefeicoes.add(ref);
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
		updateRefeicoes();
		return tela;
	}

	public void btnAddRefeicaoPressionado() {
		controller.showAdicionarRefeicao();

	}

	public void btnResetPressionado() {
		int op = JOptionPane.showConfirmDialog(tela,
				"Deseja resetar a contagem atual?", "Reset",
				JOptionPane.YES_NO_OPTION);
		if (op == 0) {
			clearRefeicoes();
		}
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
		Float altura = Float.parseFloat(JOptionPane.showInputDialog(tela,
				"Altura atual: " + controller.getLoggedUser().getAltura()
						+ "m \n" + "Digite nova altura:"));
		Float peso = Float.parseFloat(JOptionPane.showInputDialog(tela,
				"Peso atual: " + controller.getLoggedUser().getPeso() + "kg \n"
						+ "Digite novo peso:"));
		controller.updateAlturaAndPeso(altura, peso);
		JOptionPane.showMessageDialog(tela, "Dados atualizados.");
	}

	public void updateRefeicoes() {
		float carb = 0;
		float prot = 0;
		float gord = 0;
		float cal = 0;
		for (Refeicao ref : addedRefeicoes) {
			carb += ref.getCarboidratos();
			prot += ref.getProteinas();
			gord += ref.getGorduras();
			cal += ref.getCalorias();
		}
		tela.updateRefeicaoData(String.valueOf(carb), String.valueOf(prot),
				String.valueOf(gord), String.valueOf(cal));
	}

	public void clearRefeicoes() {
		addedRefeicoes.clear();
		updateRefeicoes();
	}

}
