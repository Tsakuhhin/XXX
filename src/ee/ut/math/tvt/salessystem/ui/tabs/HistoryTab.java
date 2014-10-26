package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab{
    
    // TODO - implement!
	
	public static DefaultTableModel model = new DefaultTableModel(); 
	public static JTable table = new JTable(model);


    public HistoryTab(){
    	
    }
    
    public static Component draw() {
        JPanel panel = new JPanel();
        // TODO - Sales history tabel
		
		model.addColumn("Date");
		model.addColumn("Time");
		model.addColumn("Total order price");
		model.addColumn("");
		// hide col
		table.getColumnModel().getColumn(3).setMinWidth(0);
		table.getColumnModel().getColumn(3).setMaxWidth(0);
		
		
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

        panel.setBorder(BorderFactory.createTitledBorder("History"));
        
        table.addMouseListener(new MouseAdapter() {
        	   @Override
        	   public void mouseClicked(MouseEvent e) {
        		   int row = table.getSelectedRow();
        		   int column = model.getColumnCount();
        		   Object[][] arrValues =  (Object[][]) model.getValueAt(row, column - 1);

        		   String[] columns = new String[] {
        		            "Id", "Name", "Price", "Quantity", "Sum"
        		        };
        		  
        		   JTable table2 = new JTable( arrValues, columns);
        		   JFrame frame = new JFrame("Invoice");
        		   frame.add(new JScrollPane(table2));
        		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		   frame.pack();
        		   frame.setVisible(true);
        		   
        	   }
        });
        
        
        return panel;
    } 
}