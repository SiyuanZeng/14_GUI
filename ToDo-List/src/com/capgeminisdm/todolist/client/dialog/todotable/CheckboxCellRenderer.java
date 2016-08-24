package com.capgeminisdm.todolist.client.dialog.todotable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CheckboxCellRenderer extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (value instanceof Boolean) {
			boolean enabled = ((Boolean) value).booleanValue();
			final JCheckBox box = new JCheckBox();
			box.setHorizontalAlignment(SwingConstants.CENTER);
			box.setSelected(enabled);

			if (enabled) {
				box.setBackground(Color.GREEN);
			} else {
				box.setBackground(Color.RED);
			}
			return box;
		}

		return super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);
	}
}
