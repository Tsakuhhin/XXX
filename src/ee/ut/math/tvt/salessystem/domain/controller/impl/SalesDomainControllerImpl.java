package ee.ut.math.tvt.salessystem.domain.controller.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.service.HibernateDataService;
import ee.ut.math.tvt.salessystem.ui.tabs.HistoryTab;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;

/**
 * Implementation of the sales domain controller.
 */
public class SalesDomainControllerImpl implements SalesDomainController {
	
	private static final Logger log = Logger
			.getLogger(SalesDomainControllerImpl.class);
	private HibernateDataService service = new HibernateDataService();
	
	public void submitCurrentPurchase(List<SoldItem> goods) throws VerificationFailedException {
		// Let's assume we have checked and found out that the buyer is underaged and
		// cannot buy chupa-chups
		//throw new VerificationFailedException("Underaged!");
		// XXX - Save purchase
		double sum = 0;
		Object[][] data = new Object[goods.size()][5];
		for (int i = 0; i < goods.size(); i++) {
			  sum += goods.get(i).getSum(); 
		      data[i][0] = goods.get(i).getId();
		      data[i][1] = goods.get(i).getName();
		      data[i][2] = goods.get(i).getPrice();
		      data[i][3] = goods.get(i).getQuantity();
		      data[i][4] = goods.get(i).getSum();
		 }	

		HistoryTab.model.addRow(new Object[]{getCurrentDateOrTime("date"), getCurrentDateOrTime("time"), sum, data});
		HistoryTab.model.fireTableDataChanged();	
	}

	public void cancelCurrentPurchase() throws VerificationFailedException {				
		// XXX - Cancel current purchase
	}
	

	public void startNewPurchase() throws VerificationFailedException {
		// XXX - Start new purchase
	}

	public List<StockItem> loadWarehouseState() {
		// XXX mock implementation
		List<StockItem> dataset = new ArrayList<StockItem>();

		StockItem chips = new StockItem(1l, "Lays chips", "Potato chips", 11.0, 5);
		StockItem chupaChups = new StockItem(2l, "Chupa-chups", "Sweets", 8.0, 8);
	    StockItem frankfurters = new StockItem(3l, "Frankfurters", "Beer sauseges", 15.0, 12);
	    StockItem beer = new StockItem(4l, "Free Beer", "Student's delight", 0.0, 100);

		dataset.add(chips);
		dataset.add(chupaChups);
		dataset.add(frankfurters);
		dataset.add(beer);

		return dataset;
	};
	
	public String getCurrentDateOrTime(String type) {
		String strDate = "";
		if (type == "date") {
			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
			Date date = new Date();
			strDate = dateFormat.format(date);
		} else {
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			strDate = dateFormat.format(date);
		}
		
		return strDate;
	}
	
	public void endSession(){
		HibernateUtil.closeSession();
	};
}
