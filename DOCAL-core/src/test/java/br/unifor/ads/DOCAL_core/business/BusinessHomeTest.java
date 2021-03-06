package br.unifor.ads.DOCAL_core.business;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unifor.ads.DOCAL_core.dao.DietaDAO;
import br.unifor.ads.DOCAL_core.dao.UsuarioDAO;
import br.unifor.ads.DOCAL_core.entity.Dieta;
import br.unifor.ads.DOCAL_core.entity.Usuario;

public class BusinessHomeTest {

	private static BusinessHome business;
	private static LoggedUserManager userManager;
	private static Usuario testUser;
	private static UsuarioDAO userDao;
	private static Dieta testDiet;
	private static DietaDAO dietDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		business = new BusinessHome();
		userManager = new LoggedUserManager();
		testUser = new Usuario("testUserJoao", "joao123", "joao321", 1.70f, 53f);
		userDao = new UsuarioDAO();
		userDao.inserir(testUser);
		testUser = userDao.findByLogin("joao123");
		userManager.logUser(testUser.getLogin(), testUser.getSenha());
		testDiet = new Dieta(testUser, "testDiet", 100f, 50f, 10f);
		dietDao = new DietaDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDao.excluir(testUser);
		business = null;
		userManager = null;
		testUser = null;
		userDao = null;
	}

	@Test
	public void testGetUserDieta() throws BusinessException {
		dietDao.inserir(testDiet);
		testDiet = dietDao.buscarPorNome(testDiet.getNome());
		String expectedNome = testDiet.getNome();
		Dieta userDiet = business.getUserDieta();
		String actualNome = userDiet.getNome();
		assertEquals(expectedNome, actualNome);
		dietDao.excluir(testDiet);
	}

	@Test
	public void testGetUserDietaWhenUserHasNoDieta() {
		try {
			business.getUserDieta();
			fail("User should not have a dieta!");
		} catch (BusinessException e) {
		}
	}

	@Test
	public void testGetNomeUsuario() {
		String expectedNome = testUser.getNome();
		String actualNome = business.getNomeUsuario();
		assertEquals("Nome did not match!", expectedNome, actualNome);
	}

	@Test
	public void testGetAlturaUsuario() {
		Float expectedAltura = testUser.getAltura();
		Float actualAltura = business.getAlturaUsuario();
		assertEquals("Altura did not match!", expectedAltura, actualAltura);
	}

	@Test
	public void testGetPesoUsuario() {
		Float expectedPeso = testUser.getPeso();
		Float actualPeso = business.getPesoUsuario();
		assertEquals("Peso did not match!", expectedPeso, actualPeso);
	}

	@Test
	public void testUpdateAlturaAndPeso() {
		Float newAltura = 1.71f;
		Float newPeso = 54f;
		business.updateAlturaAndPeso(newAltura, newPeso);
		testUser = userManager.getLoggedUser();
		assertEquals("New altura did not match!", newAltura,
				testUser.getAltura());
		assertEquals("New peso did not match!", newPeso, testUser.getPeso());
	}

	@Test
	public void testLogOut() {
		business.logOut();
		assertNull("loggedUser should be null", userManager.getLoggedUser());
		userManager.logUser(testUser.getLogin(), testUser.getSenha());
	}

}
