package com.capgeminisdm.todolist.client.dialog.todotable;

import java.util.Date;

import javax.swing.ListModel;

import com.capgeminisdm.todolist.kernel.to.ProjectTO;
import com.capgeminisdm.todolist.kernel.to.ToDoItemTO;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.sun.xml.internal.bind.v2.util.FatalAdapter;

public class ToDoListTableModel extends AbstractTableAdapter<ToDoItemTO> {
	public static final Integer DESCRIPTION_COLUMN_ID = 0;
	public static final String DESCRIPTION_COLUMN_NAME = "Description";
	public static final Integer DUE_DATE_COLUMN_ID = 1;
	public static final String DUE_DATE_COLUMN_NAME = "Due Date";
	public static final Integer FINISHED_COLUMN_ID = 2;
	public static final String FINISHED_COLUMN_NAME = "Finished";
	public static final Integer PROJECT_COLUMN_ID = 3;
	public static final String PROJECT_COLUMN_NAME = "Project";

	/**
	 * Default constructor.
	 * 
	 * @param listModel
	 *            The items to display.
	 */
	public ToDoListTableModel(ListModel listModel) {
		super(listModel, DESCRIPTION_COLUMN_NAME, DUE_DATE_COLUMN_NAME,
				FINISHED_COLUMN_NAME, PROJECT_COLUMN_NAME);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (DESCRIPTION_COLUMN_ID.equals(columnIndex)) {
			return String.class;
		} else if (DUE_DATE_COLUMN_ID.equals(columnIndex)) {
			return Date.class;
		} else if (FINISHED_COLUMN_ID.equals(columnIndex)) {
			return Boolean.class;
		} else if (PROJECT_COLUMN_ID.equals(columnIndex)) {
			return ProjectTO.class;
		}
		return super.getColumnClass(columnIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ToDoItemTO item = getRow(rowIndex);
		if (DESCRIPTION_COLUMN_ID.equals(columnIndex)) {
			return item.getDescription();
		} else if (DUE_DATE_COLUMN_ID.equals(columnIndex)) {
			return item.getDueDate();
		} else if (FINISHED_COLUMN_ID.equals(columnIndex)) {
			return item.getFinished();
		} else if (PROJECT_COLUMN_ID.equals(columnIndex)) {
			return item.getProject();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#setValueAt(java.lang.Object,
	 * int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ToDoItemTO toDoItem = getRow(rowIndex);
		if (DESCRIPTION_COLUMN_ID.equals(columnIndex)) {
			toDoItem.setDescription((String) aValue);
		} else if (DUE_DATE_COLUMN_ID.equals(columnIndex)) {
			toDoItem.setDueDate((Date) aValue);
		} else if (FINISHED_COLUMN_ID.equals(columnIndex)) {
			toDoItem.setFinished((Boolean) aValue);
		} else if (PROJECT_COLUMN_ID.equals(columnIndex)) {
			toDoItem.setProject((ProjectTO) aValue);
		}
	}
}