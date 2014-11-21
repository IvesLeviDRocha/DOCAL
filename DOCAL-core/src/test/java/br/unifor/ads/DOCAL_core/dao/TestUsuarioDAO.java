package br.unifor.ads.DOCAL_core.dao;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.unifor.ads.DOCAL_core.entity.Usuario;

public class TestUsuarioDAO {

	private UsuarioDAO dao;

	@Before
	public void init() {
		dao = new UsuarioDAO();
	}

	@Test
	public void testInserir() {
		Usuario usuario = new Usuario();
		String nomeUsuario = "Pessoa";
		String loginUsuario = "*****";
		String senhaUsuario = "******";
		Float alturaUsuario = 0f;
		Float pesoUsuario = 0f;
		usuario.setNome(nomeUsuario);
		usuario.setLogin(loginUsuario);
		usuario.setSenha(senhaUsuario);
		usuario.setAltura(alturaUsuario);
		usuario.setPeso(pesoUsuario);

		dao.inserir(usuario);
		assertNotNull(dao.buscarPorNome(nomeUsuario));
		assertNotNull(dao.buscarTodos());

	}

	@Test
	public void testExcluir() {
		Usuario usuario = new Usuario();
		Integer idUsuario = 1;
		String nomeUsuario = "Pessoa";
		String loginUsuario = "*****";
		String senhaUsuario = "******";
		Float alturaUsuario = 0f;
		Float pesoUsuario = 0f;
		usuario.setId(idUsuario);
		usuario.setNome(nomeUsuario);
		usuario.setLogin(loginUsuario);
		usuario.setSenha(senhaUsuario);
		usuario.setAltura(alturaUsuario);
		usuario.setPeso(pesoUsuario);

		dao.inserir(usuario);
		usuario = dao.buscarPorNome(nomeUsuario);
		dao.excluir(usuario);
		int id = usuario.getId();
		usuario = dao.findById(id);
		assertNull(usuario);
		

	}
	
	
	
	
	
	
}
