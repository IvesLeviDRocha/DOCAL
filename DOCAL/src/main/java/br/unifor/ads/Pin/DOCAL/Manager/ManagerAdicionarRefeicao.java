package br.unifor.ads.Pin.DOCAL.Manager;

import java.util.List;

import br.unifor.ads.DOCAL_core.business.BusinessAdicionarRefeicao;
import br.unifor.ads.DOCAL_core.entity.Refeicao;
import br.unifor.ads.Pin.DOCAL.Telas.PopUpper;
import br.unifor.ads.Pin.DOCAL.Telas.TelaAdicionarRefeicao;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre
 * TelaAdicionarRefeicao e o resto da aplicacao.
 */
public class ManagerAdicionarRefeicao {

	private FrameController controller;
	private TelaAdicionarRefeicao tela;
	private BusinessAdicionarRefeicao business;
	private PopUpper popUp;

	public ManagerAdicionarRefeicao(FrameController controller) {
		this.controller = controller;
		tela = new TelaAdicionarRefeicao(this);
		business = new BusinessAdicionarRefeicao();
		popUp = new PopUpper();
	}

	public TelaAdicionarRefeicao getTela() {
		List<Refeicao> refeicaoData = business.getRefeicaoData();
		tela.loadRefeicaoData(refeicaoData);
		tela.limparForms();
		tela.pesquisa();
		return tela;
	}

	public void btnAdicionarPressionado(Refeicao ref) {
		controller.addRefeicao(ref);
		controller.showHome();
	}

	public void btnCadastrarNovaPressionado() {
		controller.showCadastroRefeicao();
	}

	public void btnCancelarPressionado() {
		controller.showHome();
	}

	public void btnRemoverPressionado(Refeicao ref, Integer row) {
		if (popUp.confirm("Deseja remover esta refeicao?")) {
			business.removeRefeicao(ref);
			tela.removeRefeicaoFromTable(row);
		}
	}

}
