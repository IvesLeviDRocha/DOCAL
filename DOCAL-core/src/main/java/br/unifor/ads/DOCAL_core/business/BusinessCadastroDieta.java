package br.unifor.ads.DOCAL_core.business;

import br.unifor.ads.DOCAL_core.dao.DietaDAO;
import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class BusinessCadastroDieta {

	private LoggedUserManager userManager;
	private DietaDAO dietaDAO;

	public BusinessCadastroDieta() {
		userManager = new LoggedUserManager();
		dietaDAO = new DietaDAO();
	}

	public Usuario getLoggedUser() {
		return userManager.getLoggedUser();
	}

	public void registerDieta(Dieta dieta) {
		Integer userId = userManager.getLoggedUserId();
		Dieta dietaAtual = dietaDAO.findByUsuarioId(userId);
		if (dietaAtual != null) {
			dietaDAO.excluir(dietaAtual);
		}
		dietaDAO.inserir(dieta);
	}

}
