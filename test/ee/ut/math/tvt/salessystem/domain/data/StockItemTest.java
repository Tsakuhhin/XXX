package ee.ut.math.tvt.salessystem.domain.data;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class StockItemTest {

	@Before
	public void setUp() {
	    item = new StockItem(3, "Cookie Crisp", "cookies", 8.50, 3); 
	}
	
	@ Test
	public void testClone(){
		StockItem item =
	            new StockItem(getId(), getName(), getDescription(), getPrice(), getQuantity());
	}
	
	@Test
	public void testGetColumn(){
		
	}
}
