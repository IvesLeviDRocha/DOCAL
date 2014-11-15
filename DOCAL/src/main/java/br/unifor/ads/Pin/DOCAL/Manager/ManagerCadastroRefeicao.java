package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL_core.business.BusinessCadastroRefeicao;
import br.unifor.ads.DOCAL_core.entity.Refeicao;
import br.unifor.ads.DOCAL_core.entity.Usuario;
import br.unifor.ads.Pin.DOCAL.Telas.PopUpper;
import br.unifor.ads.Pin.DOCAL.Telas.TelaCadastroRefeicao;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre
 * TelaCadastroRefeicao e o resto da aplicacao.
 */
public class ManagerCadastroRefeicao {

	private FrameController controller;
	private TelaCadastroRefeicao tela;
	private BusinessCadastroRefeicao business;
	private PopUpper popUp;

	public ManagerCadastroRefeicao(FrameController controller) {
		this.controller = controller;
		tela = new TelaCadastroRefeicao(this);
		business = new BusinessCadastroRefeicao();
		popUp = new PopUpper();
	}

	public void btnCadastrarPressionado(String nome, String carb, String prot,
			String gord) {
		Refeicao refeicao = createRefeicao(nome, carb, prot, gord);
		if (refeicao != null) {
			business.registerRefeicao(refeicao);
			controller.showAdicionarRefeicao();
		}
		tela.limparFormularios();
	}

	public void btnCancelarPressionado() {
		controller.showAdicionarRefeicao();
		tela.limparFormularios();
	}

	public TelaCadastroRefeicao getTela() {
		return tela;
	}

	public Refeicao createRefeicao(String nome, String carb, String prot,
			String gord) {
		try {
			Float carbNum = Float.parseFloat(carb);
			Float protNum = Float.parseFloat(prot);
			Float gordNum = Float.parseFloat(gord);
			Usuario user = business.getLoggedUser();
			Refeicao refeicao = new Refeicao(user, nome, carbNum, protNum,
					gordNum);
			return refeicao;
		} catch (NumberFormatException e) {
			popUp.show("Valores invalidos.");
			return null;
		}
	}

}
