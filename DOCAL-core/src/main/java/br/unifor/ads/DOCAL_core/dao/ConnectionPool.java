package br.unifor.ads.DOCAL_core.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

/**
 * Esta classe tem a responsabilidade de ser o pool de conexoes
 * da aplicacao.
 */
public class ConnectionPool {
	
	private static final BoneCP POOL = initPool();
	
	private static BoneCP initPool() {
		BoneCPConfig config = initConfig();
		try {
			return new BoneCP(config);
		} catch (SQLException e) {
			System.out.println("Não foi possível conectar!");
			System.exit(0);
			return null;
		}
	}

	private static BoneCPConfig initConfig() {
		BoneCPConfig config = new BoneCPConfig();
		config.setJdbcUrl("jdbc:postgresql://localhost:5432/DOCAL");
		config.setUser("postgres");
		config.setPassword("postgres");
		config.setMinConnectionsPerPartition(3);
		config.setMaxConnectionsPerPartition(50);
		config.setPartitionCount(1);
		return config;
	}
	
	public static Connection getConnection() throws SQLException {
		return POOL.getConnection();
	}

}
