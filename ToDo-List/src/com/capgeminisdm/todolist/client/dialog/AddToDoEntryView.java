/*
 * Created by JFormDesigner on Sun Oct 25 15:48:11 CET 2009
 */

package com.capgeminisdm.todolist.client.dialog;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import org.jdesktop.swingx.*;

/**
 * View implementation of the "add todo entry" view.
 * 
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 */
public class AddToDoEntryView extends JDialog {
	public AddToDoEntryView(Frame owner) {
		super(owner);
		initComponents();
	}

	public AddToDoEntryView(Dialog owner) {
		super(owner);
		initComponents();
	}

	public JTextField getDescriptionTextField() {
		return descriptionTextField;
	}
	
	/**
	 * Close the dialog.
	 * 
	 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
	 * @see #setVisible(boolean)
	 * @see #dispose()
	 */
	public void closeDialog(){
		setVisible(false);
		dispose();
	}

	public JXDatePicker getDueDatePicker() {
		return dueDatePicker;
	}

	public JComboBox getProjectComboBox() {
		return projectComboBox;
	}

	public JButton getAddEntryButton() {
		return addEntryButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextArea getValidationTextArea() {
		return validationTextArea;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		label1 = new JLabel();
		descriptionTextField = new JTextField();
		label2 = new JLabel();
		dueDatePicker = new JXDatePicker();
		label3 = new JLabel();
		projectComboBox = new JComboBox();
		label4 = new JLabel();
		scrollPane1 = new JScrollPane();
		validationTextArea = new JTextArea();
		panel1 = new JPanel();
		addEntryButton = new JButton();
		cancelButton = new JButton();
		CellConstraints cc = new CellConstraints();

		//======== this ========
		setTitle("Add a To Do Entry");
		setResizable(false);
		setName("this");
		Container contentPane = getContentPane();
		contentPane.setLayout(new FormLayout(
			new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.DEFAULT, FormSpec.DEFAULT_GROW)
			},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC,
				new RowSpec(RowSpec.TOP, Sizes.dluY(43), FormSpec.NO_GROW),
				FormFactory.LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC
			}));

		//---- label1 ----
		label1.setText("Description:");
		label1.setName("label1");
		contentPane.add(label1, cc.xy(1, 1));

		//---- descriptionTextField ----
		descriptionTextField.setName("descriptionTextField");
		contentPane.add(descriptionTextField, cc.xy(3, 1));

		//---- label2 ----
		label2.setText("Due Date:");
		label2.setName("label2");
		contentPane.add(label2, cc.xy(1, 3));

		//---- dueDatePicker ----
		dueDatePicker.setName("dueDatePicker");
		contentPane.add(dueDatePicker, cc.xy(3, 3));

		//---- label3 ----
		label3.setText("Project: ");
		label3.setName("label3");
		contentPane.add(label3, cc.xy(1, 5));

		//---- projectComboBox ----
		projectComboBox.setName("projectComboBox");
		contentPane.add(projectComboBox, cc.xy(3, 5));

		//---- label4 ----
		label4.setText("Validation:");
		label4.setName("label4");
		contentPane.add(label4, cc.xy(1, 7));

		//======== scrollPane1 ========
		{
			scrollPane1.setName("scrollPane1");

			//---- validationTextArea ----
			validationTextArea.setRows(4);
			validationTextArea.setEditable(false);
			validationTextArea.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
			validationTextArea.setLineWrap(true);
			validationTextArea.setFocusTraversalPolicyProvider(true);
			validationTextArea.setName("validationTextArea");
			scrollPane1.setViewportView(validationTextArea);
		}
		contentPane.add(scrollPane1, cc.xy(3, 7));

		//======== panel1 ========
		{
			panel1.setName("panel1");
			panel1.setLayout(new FormLayout(
				new ColumnSpec[] {
					new ColumnSpec(ColumnSpec.FILL, Sizes.DEFAULT, FormSpec.DEFAULT_GROW),
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC
				},
				RowSpec.decodeSpecs("default")));

			//---- addEntryButton ----
			addEntryButton.setText("Add Entry");
			addEntryButton.setName("addEntryButton");
			panel1.add(addEntryButton, cc.xy(3, 1));

			//---- cancelButton ----
			cancelButton.setText("Cancel");
			cancelButton.setName("cancelButton");
			panel1.add(cancelButton, cc.xy(5, 1));
		}
		contentPane.add(panel1, cc.xy(3, 9));
		setSize(490, 210);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel label1;
	private JTextField descriptionTextField;
	private JLabel label2;
	private JXDatePicker dueDatePicker;
	private JLabel label3;
	private JComboBox projectComboBox;
	private JLabel label4;
	private JScrollPane scrollPane1;
	private JTextArea validationTextArea;
	private JPanel panel1;
	private JButton addEntryButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
