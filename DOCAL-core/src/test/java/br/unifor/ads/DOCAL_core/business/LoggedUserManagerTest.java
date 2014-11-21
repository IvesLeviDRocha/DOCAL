package br.unifor.ads.DOCAL_core.business;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unifor.ads.DOCAL_core.dao.UsuarioDAO;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class LoggedUserManagerTest {

	private static LoggedUserManager userManager;
	private static Usuario testUser;
	private static UsuarioDAO userDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userManager = new LoggedUserManager();
		testUser = new Usuario("testUserJoao", "joao123", "joao321", 1.70f, 53f);
		userDao = new UsuarioDAO();
		userDao.inserir(testUser);
		testUser = userDao.findByLogin("joao123");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDao.excluir(testUser);
		userManager = null;
		testUser = null;
		userDao = null;
	}

	@Test
	public void testLogUser() {
		String login = testUser.getLogin();
		String password = testUser.getSenha();
		assertTrue("Login should succeed!", userManager.logUser(login, password));
	}

	@Test
	public void testLogUserNotRegistered() {
		String login = "thisUserIsNotRegistered";
		String password = testUser.getSenha();
		assertFalse("Login should fail!", userManager.logUser(login, password));
	}

	@Test
	public void testLogUserWrongPassword() {
		String login = testUser.getLogin();
		String password = "wrongPassword";
		assertFalse("Login should fail!", userManager.logUser(login, password));
	}

	@Test
	public void testLogOut() {
		userManager.logOut();
		assertNull("loggedUser should be null!", userManager.getLoggedUser());
	}

	@Test
	public void testGetLoggedUserId() {
		String login = testUser.getLogin();
		String password = testUser.getSenha();
		userManager.logUser(login, password);
		assertNotNull("loggedUserId should not be null!", userManager.getLoggedUserId());
	}

}
