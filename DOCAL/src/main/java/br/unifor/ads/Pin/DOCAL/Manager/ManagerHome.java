package br.unifor.ads.Pin.DOCAL.Manager;

import java.util.ArrayList;
import java.util.List;

import br.unifor.ads.DOCAL_core.business.BusinessException;
import br.unifor.ads.DOCAL_core.business.BusinessHome;
import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.DOCAL_core.entity.Refeicao;
import br.unifor.ads.Pin.DOCAL.Telas.InputException;
import br.unifor.ads.Pin.DOCAL.Telas.PopUpper;
import br.unifor.ads.Pin.DOCAL.Telas.TelaHome;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre TelaHome e o
 * resto da aplicacao.
 */
public class ManagerHome {

	private FrameController controller;
	private TelaHome tela;
	private PopUpper popUp;
	private BusinessHome business;

	private List<Refeicao> addedRefeicoes;

	public ManagerHome(FrameController controller) {
		this.controller = controller;
		this.tela = new TelaHome(this);
		this.popUp = new PopUpper();
		this.business = new BusinessHome();
		addedRefeicoes = new ArrayList<Refeicao>();
	}

	public void addRefeicao(Refeicao ref) {
		addedRefeicoes.add(ref);
	}

	public TelaHome getTela() {
		updateData();
		updateRefeicoes();
		return tela;
	}

	private void updateData() {
		String userName = business.getNomeUsuario();
		try {
			Dieta userDiet = business.getUserDieta();
			tela.updateUserData(userName, userDiet);
		} catch (BusinessException e) {
			popUp.show(e.getMessage());
			tela.updateUserName(userName);
		}
	}

	public void btnAddRefeicaoPressionado() {
		controller.showAdicionarRefeicao();
	}

	public void btnResetPressionado() {
		if (popUp.confirm("Deseja resetar a contagem atual?")) {
			clearRefeicoes();
		}
	}

	public void btnNovaDietaPressionado() {
		controller.showCadastroDieta();
	}

	public void btnSairPressionado() {
		if (popUp.confirm("Deseja sair?")) {
			controller.showLogin();
			business.logOut();
		}
	}

	public void btnAtualizarDadosPressionado() {
		Float alturaAtual = business.getAlturaUsuario();
		Float pesoAtual = business.getPesoUsuario();
		String messageAltura = "Altura atual: " + alturaAtual
				+ "m \n Digite nova altura:";
		String messagePeso = "Peso atual: " + pesoAtual
				+ "m \n Digite novo peso:";
		try {
			Float altura = Float.parseFloat(popUp.receiveInput(messageAltura));
			Float peso = Float.parseFloat(popUp.receiveInput(messagePeso));
			business.updateAlturaAndPeso(altura, peso);
			popUp.show("Dados atualizados.");
		} catch (NumberFormatException e) {
			popUp.show("Valores invalidos.");
		} catch (InputException e) {
			popUp.show("Os dados não foram atualizados.");
		}
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
