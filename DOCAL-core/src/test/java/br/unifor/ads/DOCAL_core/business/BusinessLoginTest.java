package br.unifor.ads.DOCAL_core.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unifor.ads.DOCAL_core.dao.UsuarioDAO;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class BusinessLoginTest {

	private static BusinessLogin business;
	private static Usuario testUser;
	private static UsuarioDAO userDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		business = new BusinessLogin();
		testUser = new Usuario("testUserJoao", "joao123", "joao321", 1.70f, 53f);
		userDao = new UsuarioDAO();
		userDao.inserir(testUser);
		testUser = userDao.findByLogin("joao123");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDao.excluir(testUser);
		business = null;
		testUser = null;
		userDao = null;
	}

	@Test
	public void testLogUserFail() {
		String login = "joao123";
		String wrongPassword = "wrongPassword";
		assertFalse("Login should fail!",
				business.logUser(login, wrongPassword));
	}

	@Test
	public void testLogUser() {
		String login = "joao123";
		String password = "joao321";
		assertTrue("Login should succeed!", business.logUser(login, password));
	}

}
