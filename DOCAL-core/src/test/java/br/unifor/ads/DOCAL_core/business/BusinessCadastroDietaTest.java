package br.unifor.ads.DOCAL_core.business;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unifor.ads.DOCAL_core.dao.DietaDAO;
import br.unifor.ads.DOCAL_core.dao.UsuarioDAO;
import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class BusinessCadastroDietaTest {
	
	private static BusinessCadastroDieta business;
	private static Dieta testDiet;
	private static DietaDAO dietDao;
	private static Usuario testUser;
	private static UsuarioDAO userDao;
	private static LoggedUserManager userManager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		business = new BusinessCadastroDieta();
		dietDao = new DietaDAO();
		userDao = new UsuarioDAO();
		userManager = new LoggedUserManager();
		testUser = new Usuario("testUserJoao", "joao123", "joao321", 1.70f, 53f);
		userDao.inserir(testUser);
		testUser = userDao.findByLogin(testUser.getLogin());
		testDiet = new Dieta(testUser, "testDiet", 100f, 50f, 10f);
		userManager.logUser(testUser.getLogin(), testUser.getSenha());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userManager.logOut();
		userDao.excluir(testUser);
		dietDao = null;
		userDao = null;
		testDiet = null;
		testUser = null;
		userManager = null;
		business = null;
	}

	@Test
	public void testGetLoggedUser() {
		userManager.logUser(testUser.getLogin(), testUser.getSenha());
		assertNotNull(business.getLoggedUser());
	}

	@Test
	public void testRegisterDieta() {
		business.registerDieta(testDiet);
		testDiet = dietDao.findByUsuarioId(testUser.getId());
		assertNotNull(testDiet);
		dietDao.excluir(testDiet);
	}
	
	@Test
	public void testRegisterDietaWhenUserAlreadyHasADieta() {
		Dieta testDiet2 = new Dieta(testUser, "testDiet2", 200f, 120f, 33f);
		business.registerDieta(testDiet2);
		testDiet2 = dietDao.findByUsuarioId(testUser.getId());
		business.registerDieta(testDiet);
		testDiet = dietDao.findByUsuarioId(testUser.getId());
		assertNotEquals(testDiet.getNome(), testDiet2.getNome());
		dietDao.excluir(testDiet);
	}

}
