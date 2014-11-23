package ee.ut.math.tvt.salessystem.ui.model;

import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

import org.junit.Before;
import org.junit.Test;

public class StockTableModelTest {
	
	StockItem item=new StockItem((long)54, "Test1", "Test1 descript", 2, 5);
	StockItem item2=new StockItem((long)45, "Test2", "Test2 descript", 5, 2);
	SoldItem item3=new SoldItem(item,3);
	
	@Before
	public void setUp(){
		tableModel=new StockTableModel();
	}

	@ Test
	public void testValidateNameUniqueness(){
		tableModel.addItem(item);
		tableModel.addItem(new StockItem((long)544,"Test1", "ResultTestUniqueName",10,55));
		assertEquals(tableModel.getItemByName("Test1").getQuantity(), 222);
	}
	
	@Test 
	public void testHasEnoughInStock(){
		tableModel.addItem(item2);
		tableModel.getItemById(item2.getId()).setQuantity(-3);
	}
	
	@ Test
	public void testGetItemByIdWhenItemExists(){
		tableModel.addItem(item);
		assertEquals(tableModel.getItemById(54),item);
	}
	
	@ Test (expected=NoSuchElementException.class)
	public void testGetItemByIdWhenThrowsException(){
		assertEquals(tableModel.getItemById(45),item2);
	}
}
