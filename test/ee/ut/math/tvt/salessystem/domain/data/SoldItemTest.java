package ee.ut.math.tvt.salessystem.domain.data;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;

public class SoldItemTest {
	
	 SoldItem item = new SoldItem("Lauaviin", 3); 
	 SoldItem item2 = new SoldItem("ZeroQuantityTest", 0);
	
	
	@Before
	public void setUp() {
	   
	}
	
	@Test
	public void testGetSum(){
		assertEquals(item.getSum(), 5, 0.0001);
	}
	
	@Test
	public void testGetSumWithZeroQuantity() {
		 assertEquals(item2.getSum(), 0, 0.0001);
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("SoldItemTest class method passed");
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		System.out.println("SoldItemTest class passed");
	}
}
