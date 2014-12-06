package br.unifor.ads.DOCAL_core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.unifor.ads.DOCAL_core.entity.Usuario;

public class UsuarioDAO {

	private EntityManager<Usuario> em = new EntityManager<Usuario>() {
		@Override
		public Usuario trataResultSet(ResultSet result) throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setId(result.getInt("id"));
			usuario.setNome(result.getString("nome"));
			usuario.setAltura(result.getFloat("altura"));
			usuario.setPeso(result.getFloat("peso"));
			usuario.setLogin(result.getString("login"));
			usuario.setSenha(result.getString("senha"));
			return usuario;
		}
	};

	public void inserir(Usuario usuario) {
		String sql = "insert into usuario (nome, altura, peso, login, senha) values (?, ?, ?, ?, ?)";
		em.execute(sql, usuario.getNome(), usuario.getAltura(),
				usuario.getPeso(), usuario.getLogin(), usuario.getSenha());
	}

	public Usuario buscarPorNome(String nome) {
		String sql = "select id, nome, altura, peso, login, senha from usuario where nome = ?";
		return (Usuario) em.getSingleResult(sql, nome);
	}

	public Usuario findById(Integer Id) {
		String sql = "select id, nome, altura, peso, login, senha from usuario where id = ?";
		return (Usuario) em.getSingleResult(sql, Id);
	}

	public Usuario findByLogin(String login) {
		String sql = "select id, nome, altura, peso, login, senha from usuario where login = ?";
		return (Usuario) em.getSingleResult(sql, login);
	}

	public List<Usuario> buscarTodos() {
		String sql = "select id, nome, altura, peso, login, senha from usuario";
		return em.resultList(sql);
	}

	public void excluir(Usuario usuario) {
		String sql = "delete from usuario where id = ?";
		em.execute(sql, usuario.getId());
	}

	public void updateAlturaAndPeso(Usuario user, Float altura, Float peso) {
		String sql = "update usuario set altura = ?, peso = ? where id = ?";
		em.execute(sql, altura, peso, user.getId());
	}

}
