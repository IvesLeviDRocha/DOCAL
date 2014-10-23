package br.unifor.ads.Pin.DOCAL.Manager;

import javax.swing.JOptionPane;

import br.unifor.ads.Pin.DOCAL.Telas.FramePrincipal;
import br.unifor.ads.Pin.DOCAL.Telas.TelaHome;

/**
 * Esta classe tem por responsabilidade realizar a conexao entre TelaHome e o
 * resto da aplicacao.
 */
public class ManagerHome extends Manager {

	private TelaHome tela;

	/**
	 * Cria o manager e sua TelaHome.
	 * 
	 * @param o
	 *            FramePrincipal responsavel por mostrar a tela.
	 */
	public ManagerHome(FramePrincipal frame) {
		super(frame);
		this.tela = new TelaHome(this);
	}

	/**
	 * 
	 * @return a TelaHome deste manager.
	 */
	public TelaHome getTela() {
		return tela;
	}

	/**
	 * Operacao relativa ao botao AdicionarRefeicao.
	 */
	public void btnAddRefeicaoPressionado() {
		getFrame().mostrarAdicionarRefeicao();

	}

	/**
	 * Operacao relativa ao botao Reset.
	 */
	public void btnResetPressionado() {
		JOptionPane.showConfirmDialog(getFrame(), "Deseja resetar a contagem atual?",
				"Reset", JOptionPane.YES_NO_OPTION);
	}

	/**
	 * Operacao relativa ao botao NovaDieta.
	 */
	public void btnNovaDietaPressionado() {
		getFrame().mostrarCadastroDieta();

	}

	/**
	 * Operacao relativa ao botao Sair.
	 */
	public void btnSairPressionado() {
		int op = JOptionPane.showConfirmDialog(getFrame(), "Sair?",
				"Sair", JOptionPane.YES_NO_OPTION);
		switch(op) {
			case 0: 
				getFrame().mostrarLogin();
				break;
			default: break;
		}

	}
	
	/**
	 * Operacao relativa ao botao AtualizarDados.
	 */
	public void btnAtualizarDadosPressionado() {
		JOptionPane.showInputDialog(getFrame(), "Digite nova altura:");
		JOptionPane.showInputDialog(getFrame(), "Digite novo peso:");
		JOptionPane.showMessageDialog(getFrame(), "Dados atualizados.");
	}
}
