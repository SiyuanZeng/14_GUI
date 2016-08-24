package com.capgeminisdm.todolist.client.dialog.todotable;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.capgeminisdm.todolist.kernel.to.ProjectTO;

public class ProjectComboboxCellRenderer extends DefaultTableCellRenderer {
	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (value instanceof ProjectTO) {
			ProjectTO projectTO = (ProjectTO) value;
			final  JComboBox box = new JComboBox();
			box.addItem(projectTO);
				
			return box;
		}

		return super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);
	}
}
