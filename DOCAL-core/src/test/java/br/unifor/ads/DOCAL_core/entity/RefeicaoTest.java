package br.unifor.ads.DOCAL_core.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RefeicaoTest {
	
	private static Refeicao ref;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ref = new Refeicao(null, "refTest", 100f, 50f, 10f);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ref = null;
	}

	@Test
	public void testGetCalorias() {
		Float expectedCal = (100f * 4 + 50f * 4 + 10f * 9);
		Float actualCal = ref.getCalorias();
		assertEquals("actualCal didn't equal expectedCal", expectedCal, actualCal);
	}

	@Test
	public void testGetRowData() {
		Vector<String> rowData = ref.getRowData();
		assertTrue("rowData not filled", rowData.size()>=4);
	}

}
