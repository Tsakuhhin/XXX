package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;


public class StockTab {

  private JButton addItem;

  private SalesSystemModel model;

  public StockTab(SalesSystemModel model) {
    this.model = model;
  }

  // warehouse stock tab - consists of a menu and a table
  public Component draw() {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gc = new GridBagConstraints();
    panel.setLayout(gb);

    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.anchor = GridBagConstraints.NORTH;
    gc.gridwidth = GridBagConstraints.REMAINDER;
    gc.weightx = 1.0d;
    gc.weighty = 0d;

    panel.add(drawStockMenuPane(), gc);

    gc.weighty = 1.0;
    gc.fill = GridBagConstraints.BOTH;
    panel.add(drawStockMainPane(), gc);
    return panel;
  }

  // warehouse menu
  private Component drawStockMenuPane() {
    JPanel panel = new JPanel();

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();

    panel.setLayout(gb);

    gc.anchor = GridBagConstraints.NORTHWEST;
    gc.weightx = 0;

    addItem = new JButton("Add");
    addItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	newItemDialog();
        }
      });
    gc.gridwidth = GridBagConstraints.RELATIVE;
    gc.weightx = 1.0;
    panel.add(addItem, gc);

    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    return panel;
  }
  
  private void newItemDialog() {
	  JFrame frame = new JFrame("New item");
  	frame.setLayout(new GridLayout(7, 2));
  	
  	final JTextField idInput = new JTextField(15);
  	frame.add(new JLabel("Id"));
  	frame.add(idInput);
  	StockTableModel modelw = model.getWarehouseTableModel();
  	int row = modelw.getRowCount();
	int column = modelw.getColumnCount();
	Object lastid = null;
	for(int i=1;i<row;i++)
    {
        for(int j=0;j<column;j++)
        {                 ;
            if (i == row - 1) {
            	lastid = modelw.getValueAt(i, 0);
            }
        }
    }
  	idInput.setText(Long.toString(Long.parseLong(lastid.toString()) + 1).toString());
  	idInput.setEditable(false);
  	
  	final JTextField nameInput = new JTextField(15);
  	frame.add(new JLabel("Name"));
  	frame.add(nameInput);
  	
  	final JTextField descInput = new JTextField(15);
  	frame.add(new JLabel("Description"));
  	frame.add(descInput);
  	
  	final JTextField priceInput = new JTextField(15);
  	frame.add(new JLabel("Price"));
  	frame.add(priceInput);
  	
  	final JTextField quantityInput = new JTextField(15);
  	frame.add(new JLabel("Quantity"));
  	frame.add(quantityInput);
    
    addItem = new JButton("Add");
    addItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	boolean result = true;
        	
        	try {
                Long.parseLong(idInput.getText());
            } catch (Exception ex) {
            	result = false;
            }
        	try {
        		Double.parseDouble(priceInput.getText());
            } catch (Exception ex) {
            	result = false;
            }
        	try {
        		Integer.parseInt(quantityInput.getText());
            } catch (Exception ex) {
            	result = false;
            }
        	
        	if (result) {
        		StockItem item =
        	            new StockItem(Long.parseLong(idInput.getText(), 10), nameInput.getText(), descInput.getText(), Double.parseDouble(priceInput.getText()), Integer.parseInt(quantityInput.getText()));
        		StockTableModel modelw = model.getWarehouseTableModel();
        		modelw.addItem(item);
        	}
        }
    });
    frame.add(addItem);
    
   frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
   frame.pack();
   frame.setVisible(true);
	  
  }


  // table of the wareshouse stock
  private Component drawStockMainPane() {
    JPanel panel = new JPanel();

    JTable table = new JTable(model.getWarehouseTableModel());

    JTableHeader header = table.getTableHeader();
    header.setReorderingAllowed(false);

    JScrollPane scrollPane = new JScrollPane(table);

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();
    gc.fill = GridBagConstraints.BOTH;
    gc.weightx = 1.0;
    gc.weighty = 1.0;

    panel.setLayout(gb);
    panel.add(scrollPane, gc);

    panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
    return panel;
  }

}
