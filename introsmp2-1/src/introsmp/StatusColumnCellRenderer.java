package introsmp;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StatusColumnCellRenderer extends DefaultTableCellRenderer {
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
		
	    //Cells are by default rendered as a JLabel.
	    JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

	    //Get the status for the current row.
	    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		    if (tableModel.getValueAt(row, col) == "Free") {
		      l.setBackground(Color.GREEN);
		    } else {
		      l.setBackground(Color.RED);
		    }

	  //Return the JLabel which renders the cell.
	  return l;

	}
}
