/*
 * Created by JFormDesigner on Sun Oct 25 15:15:08 CET 2009
 */

package com.capgeminisdm.todolist.client.dialog;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import org.jdesktop.swingx.*;

/**
 * The Todo List view implementation.
 *
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 */
public class ToDoListView extends JPanel {
	public ToDoListView() {
		initComponents();
	}

	public JButton getAddToDoEntryButton() {
		return addToDoEntryButton;
	}

	public JXTable getToDoListTable() {
		return toDoListTable;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		label1 = new JLabel();
		panel1 = new JPanel();
		addToDoEntryButton = new JButton();
		scrollPane1 = new JScrollPane();
		toDoListTable = new JXTable();
		CellConstraints cc = new CellConstraints();

		//======== this ========
		setName("this");
		setLayout(new FormLayout(
			ColumnSpec.decodeSpecs("default:grow"),
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC
			}));

		//---- label1 ----
		label1.setText("Simple To Do List ");
		label1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label1.setName("label1");
		add(label1, cc.xy(1, 1));

		//======== panel1 ========
		{
			panel1.setName("panel1");
			panel1.setLayout(new FormLayout(
				new ColumnSpec[] {
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
					new ColumnSpec(ColumnSpec.FILL, Sizes.dluX(243), FormSpec.DEFAULT_GROW)
				},
				RowSpec.decodeSpecs("default")));

			//---- addToDoEntryButton ----
			addToDoEntryButton.setText("Add To Do Entry");
			addToDoEntryButton.setName("addToDoEntryButton");
			panel1.add(addToDoEntryButton, cc.xy(1, 1));
		}
		add(panel1, cc.xy(1, 3));

		//======== scrollPane1 ========
		{
			scrollPane1.setName("scrollPane1");

			//---- toDoListTable ----
			toDoListTable.setName("toDoListTable");
			scrollPane1.setViewportView(toDoListTable);
		}
		add(scrollPane1, cc.xy(1, 5));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel label1;
	private JPanel panel1;
	private JButton addToDoEntryButton;
	private JScrollPane scrollPane1;
	private JXTable toDoListTable;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
