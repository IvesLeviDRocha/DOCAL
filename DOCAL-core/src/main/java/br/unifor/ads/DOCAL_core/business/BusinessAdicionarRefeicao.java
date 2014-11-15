package br.unifor.ads.DOCAL_core.business;

import java.util.ArrayList;
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
		List<Object> list = refeicaoDAO.findByUserId(userManager.getLoggedUserId());
		List<Refeicao> refeicaoData = new ArrayList<Refeicao>();
		for (Object obj : list) {
			Refeicao ref = (Refeicao) obj;
			refeicaoData.add(ref);
		}
		return refeicaoData;
	}
	
	public void removeRefeicao(Refeicao refeicao) {
		refeicaoDAO.excluir(refeicao);
	}
	
}
