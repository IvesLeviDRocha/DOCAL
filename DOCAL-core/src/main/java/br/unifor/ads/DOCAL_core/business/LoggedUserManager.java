package br.unifor.ads.DOCAL_core.business;

import br.unifor.ads.DOCAL_core.dao.UsuarioDAO;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class LoggedUserManager {

	private static Usuario loggedUser;
	private UsuarioDAO userDAO;

	public LoggedUserManager() {
		userDAO = new UsuarioDAO();
	}

	public boolean logUser(String login, String senha) {
		Usuario user = userDAO.findByLogin(login);
		if (user == null) {
			return false;
		} else {
			if (user.getSenha().equals(senha)) {
				setLoggedUser(user);
				return true;
			} else {
				return false;
			}
		}
	}

	public void logOut() {
		loggedUser = null;
	}

	private void setLoggedUser(Usuario user) {
		loggedUser = user;
	}

	public Usuario getLoggedUser() {
		return loggedUser;
	}
	
	public Integer getLoggedUserId() {
		return loggedUser.getId();
	}

}
