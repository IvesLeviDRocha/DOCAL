package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL.controller.Controller;
import br.unifor.ads.DOCAL_core.entity.Refeicao;
import br.unifor.ads.DOCAL_core.entity.Usuario;
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

	public void btnCadastrarPressionado(String nome, String carb, String prot,
			String gord) {
		Refeicao refeicao = createRefeicao(nome, carb, prot, gord);
		controller.registerRefeicao(refeicao);
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

	public Refeicao createRefeicao(String nome, String carb, String prot,
			String gord) {
		Float carbNum = Float.parseFloat(carb);
		Float protNum = Float.parseFloat(prot);
		Float gordNum = Float.parseFloat(gord);
		Usuario user = controller.getLoggedUser();
		Refeicao refeicao = new Refeicao(user, nome, carbNum, protNum, gordNum);
		return refeicao;
	}

}
