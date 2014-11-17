Task 1. Covering POS with Automatic Tests.
Add JUnit framework support to your POS project. You need to add the corresponding jar file junit-4.10.jar as a library to your project, create one more source folder test for your test classes and add ANT script target to run the tests (see first demo application as an example).

Most of the applications (and SalesSystem is not an exception) have many classes. Some of them is difficult or not reasonable to cover with the unit tests (depend on many external actions, etc). Ease of the unit test development is a sign of a good architecture and design.

In your current SalesSystem version such difficulties are: external database, Hibernate and their strong relationship with other application parts. Also it is quite difficult to test fat client GUI. Nevertheless, it is relatively easy to cover model classes and JTable helping classes like StockTableModel. Here is the list of the classes and tests that should be implemented:

SaleTest/PurchaseTest/... (name depends on your solution of the lab 4):
testAddSoldItem()
testGetSumWithNoItems()
testGetSumWithOneItem()
testGetSumWithMultipleItems()
StockItemTest
testClone()
testGetColumn()
SoldItemTest
testGetSum()
testGetSumWithZeroQuantity()
StockTableModelTest
testValidateNameUniqueness()
testHasEnoughInStock()
testGetItemByIdWhenItemExists()
testGetItemByIdWhenThrowsException()
You need to develop the tests above. You also should add your own tests where possible. Do not implement trivial tests like checking if the class constructor creates a new object or checking if the getter method returns the same value that the setter method set!
Find at least two more model classes that can be covered with nontrivial unit tests. Implement unit tests for found classes.
