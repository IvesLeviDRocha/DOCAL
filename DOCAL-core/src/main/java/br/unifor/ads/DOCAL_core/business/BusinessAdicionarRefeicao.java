package br.unifor.ads.DOCAL_core.business;

import java.util.List;

import br.unifor.ads.DOCAL_core.dao.RefeicaoDAO;
import br.unifor.ads.DOCAL_core.entity.Refeicao;

public class BusinessAdicionarRefeicao {
	
	private LoggedUserManager userManager;
	private RefeicaoDAO refeicaoDAO;
	
	public BusinessAdicionarRefeicao() {
		userManager = new LoggedUserManager();
		refeicaoDAO = new RefeicaoDAO();
	}
	
	public List<Refeicao> getRefeicaoData() {
		return refeicaoDAO.findByUserId(userManager.getLoggedUserId());
	}
	
	public void removeRefeicao(Refeicao refeicao) {
		refeicaoDAO.excluir(refeicao);
	}
	
}
