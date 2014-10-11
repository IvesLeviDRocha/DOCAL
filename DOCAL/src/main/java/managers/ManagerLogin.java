package managers;

import telas.TelaLogin;

/**
 * Esta classe tem por responsabilidade realizar a conexao
 * entre TelaLogin e o resto da aplicacao.
 */
public class ManagerLogin extends Manager {

	private TelaLogin tela;

	/**
	 * Cria o manager e sua TelaLogin.
	 * @param o FramePrincipal responsavel por mostrar a tela.
	 */
	public ManagerLogin(FramePrincipal frame) {
		super(frame);
		this.tela = new TelaLogin(this);
	}
	
	/**
	 * @return a TelaLogin deste manager.
	 */
	public TelaLogin getTela() {
		return tela;
	}
	
	/**
	 * Operacao relativa ao botao Entrar.
	 */
	public void btnEntrarPressionado() {
		getFrame().mostrarHome();
	}
	
	/**
	 * Operacao relativa ao botao Cadastrar.
	 */
	public void btnCadastrarPressionado() {
		getFrame().mostrarCadastroUsuario();
	}
	
}
