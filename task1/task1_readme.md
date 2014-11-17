For this task we will use the following code: lab6-refactoring-POS.zip

PurchaseInfoTableModel has a List<SoldItem> (inherited from class SalesSystemTableModel) and Sale has a Set<SoldItem>. You should get rid of this code duplication. The most reasonable way to do it would be to use the Sale object in the PurchaseInfoTableModel to get the rows. To add this modification in the architecture you need to remove List<T> rows from SalesSystemTableModel class and change the method public List<T> getTableRows to abstract, that would be then implemented separately in each inheriting class.

In the given project all stock tab, client tab and history tab data refresh action on data change. You need to rewrite this logic and refresh the tab data (load latest state from the database) on the tab select action.

The use of the object model during the Sale should be approximately as following:

User chooses the client and makes the purchase
Client client = … 
Sale sale = new Sale(client);
User chooses the product and adds it to the cart:
StockItem stockItem = …
// create the SoldItem object if needed and add it to the sale or use already existing one and change the quantity
sale.addItem(stockItem);
User completes the purchase:
sale.setSellingTime(new Date());
Replace the method submitCurrentPurchase(List<SoldItem> goods, Client currentClient) with the new method:
salesDomainController.registerSale(sale);
For sure you also need the StockItem quantity

Recommended work order:

Temporarily forget all the GUI and modify the object model according to the instructions above.
Fix the GUI. Start from the SaleSystemTableModel, where you will loose the rows. Next, modify the XxxTableModel classes - PurchaseInfoTableModel will use the Sale object, StockTableModel should keep it's own rows.
Add refresh() method to the stock, client and history tabs to load the latest state from the database. The table rows should be read from the database using the domain controller and passed to the models. Remember to trigger the refresh on every tab activation.
Code cleanup. Obviously, there would be many unused methods left after the refactoring like in class SalesDomainControllerImpl. You need to remove all unused code.