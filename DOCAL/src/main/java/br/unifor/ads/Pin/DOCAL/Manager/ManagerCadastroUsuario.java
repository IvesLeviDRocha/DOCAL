package br.unifor.ads.Pin.DOCAL.Manager;

import javax.swing.JOptionPane;

import br.unifor.ads.Pin.DOCAL.Telas.FramePrincipal;
import br.unifor.ads.Pin.DOCAL.Telas.TelaCadastroUsuario;

/**
 * Esta classe tem por responsabilidade realizar a conexao
 * entre TelaCadastroUsuario e o resto da aplicacao.
 */
public class ManagerCadastroUsuario extends Manager {

	private TelaCadastroUsuario tela;
	
	/**
	 * Cria o manager e sua TelaCadastroUsuario.
	 * @param o FramePrincipal responsavel por mostrar a tela.
	 */
	public ManagerCadastroUsuario(FramePrincipal frame) {
		super(frame);
		this.tela = new TelaCadastroUsuario(this);
	}
	
	/**
	 * 
	 * @return a TelaCadastroUsuario deste manager.
	 */
	public TelaCadastroUsuario getTela() {
		return tela;
	}
	
	/**
	 * Operacao relativa ao botao Cancelar.
	 */
	public void btnCancelarPressionado() {
		getFrame().mostrarLogin();
		tela.limparFormularios();
	}
	
	/**
	 * Operacao relativa ao botao Cadastrar.
	 */
	public void btnCadastrarPressionado() {
		getFrame().mostrarHome();
		tela.limparFormularios();
	}
	
	/**
	 * Operacao relativa ao botao Limpar.
	 */
	public void btnLimparPressionado() {
		tela.limparFormularios();
	}
	
}
