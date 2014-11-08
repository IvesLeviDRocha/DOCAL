package br.unifor.ads.DOCAL.controller;

import br.unifor.ads.DOCAL_core.dao.UsuarioDAO;
import br.unifor.ads.DOCAL_core.entity.Usuario;
import br.unifor.ads.Pin.DOCAL.Manager.ManagerAdicionarRefeicao;
import br.unifor.ads.Pin.DOCAL.Manager.ManagerCadastroDieta;
import br.unifor.ads.Pin.DOCAL.Manager.ManagerCadastroRefeicao;
import br.unifor.ads.Pin.DOCAL.Manager.ManagerCadastroUsuario;
import br.unifor.ads.Pin.DOCAL.Manager.ManagerHome;
import br.unifor.ads.Pin.DOCAL.Manager.ManagerLogin;
import br.unifor.ads.Pin.DOCAL.Telas.FramePrincipal;

public class Controller {

	private Usuario loggedUser;

	private FramePrincipal frame;
	private ManagerLogin managerLogin;
	private ManagerHome managerHome;
	private ManagerCadastroUsuario managerCadUser;
	private ManagerCadastroDieta managerCadDieta;
	private ManagerCadastroRefeicao managerCadRef;
	private ManagerAdicionarRefeicao managerAddRef;

	public Controller() {
		managerLogin = new ManagerLogin(this);
		managerHome = new ManagerHome(this);
		managerCadUser = new ManagerCadastroUsuario(this);
		managerCadDieta = new ManagerCadastroDieta(this);
		managerCadRef = new ManagerCadastroRefeicao(this);
		managerAddRef = new ManagerAdicionarRefeicao(this);
		frame = new FramePrincipal(managerLogin.getTela());
	}

	public void setLoggedUser(Usuario user) {
		this.loggedUser = user;
	}

	public Usuario getLoggedUser() {
		return loggedUser;
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
	
	public void registerUsuario(Usuario user) {
		UsuarioDAO.inserir(user);
	}

}
