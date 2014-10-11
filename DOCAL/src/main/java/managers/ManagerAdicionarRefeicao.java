package managers;

import telas.TelaAdicionarRefeicao;

/**
 * Esta classe tem por responsabilidade realizar a conexao
 * entre TelaAdicionarRefeicao e o resto da aplicacao.
 */
public class ManagerAdicionarRefeicao extends Manager {
	
	private TelaAdicionarRefeicao tela;
	
	/**
	 * Cria o manager e sua TelaAdicionarRefeicao.
	 * @param o FramePrincipal responsavel por mostrar a tela.
	 */
	public ManagerAdicionarRefeicao(FramePrincipal frame) {
		super(frame);
		this.tela = new TelaAdicionarRefeicao(this);
		
	}
	
	/**
	 * 
	 * @return a TelaAdicionarRefeicao deste manager.
	 */
	public TelaAdicionarRefeicao getTela() {
		return tela;
	}
	
	/**
	 * Operacao relativa ao botao Adicionar.
	 */
	public void btnAdicionarPressionado() {
		getFrame().mostrarHome();
	}
	
	/**
	 * Operacao relativa ao botao CadastrarNova.
	 */
	public void btnCadastrarNovaPressionado() {
		getFrame().mostrarCadastroRefeicao();
		
	}
	
	/**
	 * Operacao relativa ao botao Cancelar.
	 */
	public void btnCancelarPressionado() {
		getFrame().mostrarHome();
		
	}
	


	
}
