package br.unifor.ads.DOCAL_core.business;

import br.unifor.ads.DOCAL_core.dao.RefeicaoDAO;
import br.unifor.ads.DOCAL_core.entity.Refeicao;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class BusinessCadastroRefeicao {

	private LoggedUserManager userManager;
	private RefeicaoDAO refeicaoDAO;
	
	public BusinessCadastroRefeicao() {
		userManager = new LoggedUserManager();
		refeicaoDAO = new RefeicaoDAO();
	}
	
	public Usuario getLoggedUser() {
		return userManager.getLoggedUser();
	}
	
	public void registerRefeicao(Refeicao refeicao) {
		refeicaoDAO.inserir(refeicao);
	}

}
