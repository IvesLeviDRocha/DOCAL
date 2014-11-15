package br.unifor.ads.DOCAL_core.business;

import br.unifor.ads.DOCAL_core.dao.UsuarioDAO;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class BusinessCadastroUsuario {
	
	private UsuarioDAO usuarioDAO;
	
	public BusinessCadastroUsuario() {
		usuarioDAO = new UsuarioDAO();
	}
	
	public boolean registerUsuario(Usuario user) {
		Integer id = user.getId();
		Usuario existente = usuarioDAO.findById(id);
		if (existente != null) {
			return false;
		} else {
			usuarioDAO.inserir(user);
			return true;
		}
	}

}
