package ee.ut.math.tvt.salessystem.domain.data;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;

public class SoldItemTest {
	
	@Before
	public void setUp() {
	    item = new SoldItem("Lauaviin", 3); 
	}
	
	@Test
	public void testGetSum(){
		item.getPrice * item.getGuantity;
	}
	
	@Test
	public void testGetSumWithZeroQuantity() {
		SoldItem item = new SoldItem(item, 0);
	    
	    assertEquals(item.getPrice(), 0.0, 0.0001);
	}
}
