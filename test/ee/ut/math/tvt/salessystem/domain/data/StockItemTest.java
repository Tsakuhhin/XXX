package ee.ut.math.tvt.salessystem.domain.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class StockItemTest {

	@Before
	public void setUp() {
		item = new StockItem(3, "Cookie Crisp", "cookies", 8.50, 3);
	}

	@Test
	public void testClone() {
		assertEquals(item.clone(), item);
	}

	@Test
	public void testGetColumn() {
		assertEquals(item.getColumn(2), 21);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("StockItemTest class method passed");
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		System.out.println("StockItemTest class passed");
	}
}
