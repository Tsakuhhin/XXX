package ee.ut.math.tvt.salessystem.ui.model;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;

/**
 * Main model. Holds all the other models.
 */
public class SalesSystemModel {
    
    private static final Logger log = Logger.getLogger(SalesSystemModel.class);

    // Warehouse model
    private StockTableModel warehouseTableModel;
    
    // Current shopping cart model
    private PurchaseInfoTableModel currentPurchaseTableModel;

    private final SalesDomainController domainController;

    /**
     * Construct application model.
     * @param domainController Sales domain controller.
     */
    public SalesSystemModel(SalesDomainController domainController) {
        this.domainController = domainController;
        
        warehouseTableModel = new StockTableModel();
        currentPurchaseTableModel = new PurchaseInfoTableModel();

        // populate stock model with data from the warehouse
        warehouseTableModel.populateWithData(domainController.loadWarehouseState());

    }

    public StockTableModel getWarehouseTableModel() {
        return warehouseTableModel;
    }

    public PurchaseInfoTableModel getCurrentPurchaseTableModel() {
        return currentPurchaseTableModel;
    }
    
    public boolean checkAmount(PurchaseInfoTableModel purchaseInfoTableModel, Long id, int quantity, int addedquantity) {
    	int Quantity = 0;
    	int nRow = purchaseInfoTableModel.getRowCount(), nCol = purchaseInfoTableModel.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0 ; i < nRow ; i++) {
            if(id == purchaseInfoTableModel.getValueAt(i,0)) {	
            	Quantity += (int) purchaseInfoTableModel.getValueAt(i,3);
            }
        }
        Quantity += addedquantity;
        
        if (quantity < Quantity) {
        	JOptionPane.showMessageDialog(null, "The amount is exceeded!");
        	return false;
        }
        
    	return true;
    }
    
}
