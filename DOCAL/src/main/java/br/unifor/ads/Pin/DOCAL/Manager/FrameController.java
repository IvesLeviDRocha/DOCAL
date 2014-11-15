package br.unifor.ads.Pin.DOCAL.Manager;

import br.unifor.ads.DOCAL_core.entity.Refeicao;
import br.unifor.ads.Pin.DOCAL.Telas.FramePrincipal;
import br.unifor.ads.Pin.DOCAL.Telas.PopUpper;

/**
 * Esta classe e responsavel por um bocado de coisa
 */
public class FrameController {

	private FramePrincipal frame;
	private ManagerLogin managerLogin;
	private ManagerHome managerHome;
	private ManagerCadastroUsuario managerCadUser;
	private ManagerCadastroDieta managerCadDieta;
	private ManagerCadastroRefeicao managerCadRef;
	private ManagerAdicionarRefeicao managerAddRef;

	public FrameController() {
		managerLogin = new ManagerLogin(this);
		managerHome = new ManagerHome(this);
		managerCadUser = new ManagerCadastroUsuario(this);
		managerCadDieta = new ManagerCadastroDieta(this);
		managerCadRef = new ManagerCadastroRefeicao(this);
		managerAddRef = new ManagerAdicionarRefeicao(this);
		frame = new FramePrincipal(managerLogin.getTela());
		PopUpper.setFrame(frame);
	}

	public void showLogin() {
		frame.showScreen(managerLogin.getTela());
	}

	public void showHome() {
		frame.showScreen(managerHome.getTela());
	}

	public void showCadastroDieta() {
		frame.showScreen(managerCadDieta.getTela());
	}

	public void showCadastroUsuario() {
		frame.showScreen(managerCadUser.getTela());
	}

	public void showCadastroRefeicao() {
		frame.showScreen(managerCadRef.getTela());
	}

	public void showAdicionarRefeicao() {
		frame.showScreen(managerAddRef.getTela());
	}

	public void sair() {
		System.exit(0);
	}

	public FramePrincipal getFrame() {
		return frame;
	}

	public void addRefeicao(Refeicao ref) {
		managerHome.addRefeicao(ref);
	}

}
