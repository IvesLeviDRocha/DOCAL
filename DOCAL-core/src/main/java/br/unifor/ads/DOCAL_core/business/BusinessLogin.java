package br.unifor.ads.DOCAL_core.business;

public class BusinessLogin {

	private LoggedUserManager userManager;

	public BusinessLogin() {
		this.userManager = new LoggedUserManager();
	}

	public boolean logUser(String login, String senha) {
		if (userManager.logUser(login, senha)) {
			return true;
		} else {
			return false;
		}
	}

}
