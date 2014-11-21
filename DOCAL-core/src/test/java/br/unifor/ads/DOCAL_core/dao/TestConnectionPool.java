package br.unifor.ads.DOCAL_core.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class TestConnectionPool {

	@Test
	public void testGetConnection() throws SQLException {
		assertNotNull("Nao retornou conexao", ConnectionPool.getConnection());
	}

}
