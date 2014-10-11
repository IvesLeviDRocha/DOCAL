package managers;

import telas.TelaHome;

/**
 * Esta classe tem por responsabilidade realizar a conexao
 * entre TelaHome e o resto da aplicacao.
 */
public class ManagerHome extends Manager {

	private TelaHome tela;

	/**
	 * Cria o manager e sua TelaHome.
	 * @param o FramePrincipal responsavel por mostrar a tela. 
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
		getFrame().mostrarHome();
		
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
		getFrame().mostrarLogin();
		
	}
}
