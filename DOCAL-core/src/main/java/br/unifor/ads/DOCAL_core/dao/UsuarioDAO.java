package br.unifor.ads.DOCAL_core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.unifor.ads.DOCAL_core.dao.EntityManager;
import br.unifor.ads.DOCAL_core.entity.Usuario;


public class UsuarioDAO {

	private EntityManager em = new EntityManager() {
		@Override
		public Object trataResultSet(ResultSet result) throws SQLException {
			Usuario usuario = null;
			if (result.next()) {
				usuario = new Usuario();
				usuario.setId(result.getInt("id"));
				usuario.setNome(result.getString("nome"));
			}
			return usuario;
		}
	};

	public void inserir(Usuario usuario) {

		String sql = "insert into usuario (nome) values (?)";
		em.execute(sql, usuario.getNome());

	}

	public Usuario buscarPorNome(String nome) {

		String sql = "select id, nome from usuario where nome = ?";
		return (Usuario) em.getSingleResult(sql, nome);

	}

	public List<Object> buscarTodos() {
		String sql = "select id, nome from usuario";
		return em.resultList(sql);

	}

	public void excluir(Usuario usuario) {

		String sql = "delete from usuario where nome = ?";
		em.execute(sql, usuario.getNome());
	}

}
