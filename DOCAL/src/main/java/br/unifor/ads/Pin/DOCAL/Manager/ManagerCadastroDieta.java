package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.Pin.DOCAL.Telas.FramePrincipal;
import br.unifor.ads.Pin.DOCAL.Telas.TelaCadastroDieta;

/**
 * Esta classe tem por responsabilidade realizar a conexao
 * entre TelaCadastroDieta e o resto da aplicacao.
 */
public class ManagerCadastroDieta extends Manager {

	private TelaCadastroDieta tela;
	
	/**
	 * Cria o manager e sua TelaCadastroDieta.
	 * @param o FramePrincipal responsavel por mostrar a tela.
	 */
	public ManagerCadastroDieta(FramePrincipal frame) {
		super(frame);
		this.tela = new TelaCadastroDieta(this);
	}
	
	/**
	 * 
	 * @return a TelaCadastroDieta deste manager.
	 */
	public TelaCadastroDieta getTela() {
		return tela;
	}
	
	/**
	 * Operacao relativa ao botao Cadastrar.
	 */
	public void btnCadastrarPressionado() {
		getFrame().mostrarHome();
		tela.limparFormularios();
	}

	/**
	 * Operacao relativa ao botao Cancelar.
	 */
	public void btnCancelarPressionado() {
		getFrame().mostrarHome();
		tela.limparFormularios();
	}
	
	
}
