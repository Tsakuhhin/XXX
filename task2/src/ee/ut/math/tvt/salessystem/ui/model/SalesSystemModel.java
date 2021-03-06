package src.ee.ut.math.tvt.salessystem.ui.model;

import src.ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import src.ee.ut.math.tvt.salessystem.domain.data.Client;
import src.ee.ut.math.tvt.salessystem.domain.data.Sale;
import src.ee.ut.math.tvt.salessystem.domain.data.StockItem;
import java.util.List;

/**
 * Main model. Holds all the other models.
 */
public class SalesSystemModel {

    // Warehouse model
    private StockTableModel warehouseTableModel;

    // Current shopping cart model
    private PurchaseInfoTableModel currentPurchaseTableModel;

    // Puchase history model
    private PurchaseHistoryTableModel purchaseHistoryTableModel;

    private ClientTableModel clientTableModel;

    private Client selectedClient;
    
    private SalesDomainController domainController;

    /**
     * Construct application model.
     * @param domainController Sales domain controller.
     */
    public SalesSystemModel(SalesDomainController domainController) {
    	this.domainController = domainController;
        warehouseTableModel = new StockTableModel(this);
        currentPurchaseTableModel = new PurchaseInfoTableModel(this);
        purchaseHistoryTableModel = new PurchaseHistoryTableModel(this);
        clientTableModel = new ClientTableModel(this);

        // Load data from the database
        /*
        List<StockItem> stockItems = domainController.getAllStockItems();
        warehouseTableModel.populateWithData(stockItems);

        List<Client> clients = domainController.getAllClients();
        clientTableModel.populateWithData(clients);

        List<Sale> sales = domainController.getAllSales();
        purchaseHistoryTableModel.populateWithData(sales);
		*/
    }

    public StockTableModel getWarehouseTableModel() {
        return warehouseTableModel;
    }

    public PurchaseInfoTableModel getCurrentPurchaseTableModel() {
        return currentPurchaseTableModel;
    }

    public PurchaseHistoryTableModel getPurchaseHistoryTableModel() {
        return purchaseHistoryTableModel;
    }

    public ClientTableModel getClientTableModel() {
        return clientTableModel;
    }

    public void setPurchaseHistoryTableModel(
            PurchaseHistoryTableModel purchaseHistoryTableModel) {
        this.purchaseHistoryTableModel = purchaseHistoryTableModel;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client client) {
        this.selectedClient = client;
    }

	public SalesDomainController getDomainController() {
		// TODO Auto-generated method stub
		return domainController;
	}

}
