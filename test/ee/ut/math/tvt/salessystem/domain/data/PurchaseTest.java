package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Test;


import ee.ut.math.tvt.salessystem.domain.data.Purchase;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;


public class PurchaseTest {

	SoldItem item = new SoldItem(new StockItem((long) 10, "Test1", "Test1 desc", 54.3, 10), 10); 
	SoldItem item2 = new SoldItem(new StockItem((long) 20, "Test2", "Tes2 desc", 55.3, 20), 20); 
	SoldItem item3 = new SoldItem(new StockItem((long) 30, "Test3", "Test3 desc", 56.3, 30), 30); 

	SoldItem[] purch = {};
	SoldItem[] purch2 = {item};
	SoldItem[] purch3 = {item, item2, item3};
	
	Purchase one=new Purchase((long)1,Arrays.asList(purch));
	Purchase two=new Purchase((long)2,Arrays.asList(purch2));
	Purchase three=new Purchase((long)3,Arrays.asList(purch3));
	
	@Test
	public void testAddSoldItem() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetSumWithNoItems() {
		assertEquals(one.calculateTotalSum(),0,0.0001);
	}
	
	@Test
	public void testGetSumWithOneItem() {
		assertEquals(two.calculateTotalSum(),10,0.0001);
	}
	
	@Test
	public void testGetSumWithMultipleItems() {
		assertEquals(three.calculateTotalSum(),110,0.0001);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Purchase test done.");
	}

	

}
