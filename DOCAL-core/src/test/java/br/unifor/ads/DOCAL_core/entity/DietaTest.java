package br.unifor.ads.DOCAL_core.entity;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DietaTest {

	private static Dieta dieta;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dieta = new Dieta(null, null, 100f, 50f, 10f);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dieta = null;
	}

	@Test
	public void testGetCalorias() {
		Float expectedCal = (100f * 4 + 50f * 4 + 10f * 9);
		Float actualCal = dieta.getCalorias();
		assertEquals("actualCal didn't equal expectedCal", expectedCal, actualCal);
	}

}
