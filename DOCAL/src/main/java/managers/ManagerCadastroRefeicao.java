package managers;

import telas.TelaCadastroRefeicao;

/**
 * Esta classe tem por responsabilidade realizar a conexao
 * entre TelaCadastroRefeicao e o resto da aplicacao.
 */
public class ManagerCadastroRefeicao extends Manager {

	private TelaCadastroRefeicao tela;
	
	/**
	 * Cria o manager e sua TelaCadastroRefeicao.
	 * @param o FramePrincipal responsavel por mostrar a tela.
	 */
	public ManagerCadastroRefeicao(FramePrincipal frame) {
		super(frame);
		this.tela = new TelaCadastroRefeicao(this);
	}
	
	/**
	 * Operacao relativa ao botao Cadastrar.
	 */
	public void btnCadastrarPressionado() {
		getFrame().mostrarAdicionarRefeicao();
	}
	
	/**
	 * Operacao relativa ao botao Cancelar.
	 */
	public void btnCancelarPressionado() {
		getFrame().mostrarAdicionarRefeicao();
	}
	
	/**
	 * 
	 * @return a TelaCadastroRefeicao deste manager.
	 */
	public TelaCadastroRefeicao getTela() {
		return tela;
	}

}
