package br.unifor.ads.DOCAL_core.business;

import br.unifor.ads.DOCAL_core.dao.DietaDAO;
import br.unifor.ads.DOCAL_core.dao.UsuarioDAO;
import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class BusinessHome {

	private LoggedUserManager userManager;
	private DietaDAO dietaDAO;
	private UsuarioDAO usuarioDAO;

	public BusinessHome() {
		userManager = new LoggedUserManager();
		dietaDAO = new DietaDAO();
		usuarioDAO = new UsuarioDAO();
	}

	public Dieta getUserDieta() throws BusinessException {
		Dieta dieta = dietaDAO.findByUsuarioId(userManager.getLoggedUserId());
		if (dieta == null) {
			throw new BusinessException("Usuario nao possui nenhuma dieta");
		}
		return dieta;
	}

	public String getNomeUsuario() {
		Usuario loggedUser = userManager.getLoggedUser();
		return loggedUser.getNome();
	}

	public Float getAlturaUsuario() {
		Usuario loggedUser = userManager.getLoggedUser();
		return loggedUser.getAltura();
	}

	public Float getPesoUsuario() {
		Usuario loggedUser = userManager.getLoggedUser();
		return loggedUser.getPeso();
	}

	public void updateAlturaAndPeso(Float altura, Float peso) {
		Usuario loggedUser = userManager.getLoggedUser();
		usuarioDAO.updateAlturaAndPeso(loggedUser, altura, peso);
		userManager.updateLoggedUser();
	}

	public void logOut() {
		userManager.logOut();
	}

}
