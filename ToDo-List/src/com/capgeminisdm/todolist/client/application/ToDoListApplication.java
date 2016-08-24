/*
CapgeminiSdmFestSample Application File
User: ddary
$Date: 2007/07/13 08:17:07 $
$Revision: 1.1 $
 */
package com.capgeminisdm.todolist.client.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import org.jdesktop.swingx.table.DatePickerCellEditor;

import com.capgeminisdm.todolist.client.dialog.AddToDoEntryView;
import com.capgeminisdm.todolist.client.dialog.ToDoListView;
import com.capgeminisdm.todolist.client.dialog.todotable.CheckboxCellRenderer;
import com.capgeminisdm.todolist.client.dialog.todotable.ProjectComboboxCellRenderer;
import com.capgeminisdm.todolist.client.dialog.todotable.ToDoListTableModel;
import com.capgeminisdm.todolist.kernel.ProjectSrv;
import com.capgeminisdm.todolist.kernel.ToDoListSrv;
import com.capgeminisdm.todolist.kernel.impl.ProjectSrvImpl;
import com.capgeminisdm.todolist.kernel.impl.ToDoListSrvImpl;
import com.capgeminisdm.todolist.kernel.to.ProjectTO;
import com.capgeminisdm.todolist.kernel.to.ToDoItemTO;
import com.jgoodies.binding.adapter.ComboBoxAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.jgoodies.binding.list.ObservableList;
import com.jgoodies.binding.list.SelectionInList;

/**
 * The main ToDoList application.
 * 
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 */
public class ToDoListApplication extends JFrame {
	private ToDoListSrv toDoListSrv = null;
	private ProjectSrv projectSrv = null;

	private ToDoListView toDoListView = null;

	private ObservableList<ToDoItemTO> toDoListModel = null;

	/**
	 * The main method to start the application
	 * 
	 * @param args
	 *            The console arguments.
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ToDoListApplication();
			}
		});

	}

	/**
	 * The default constructor of the application.
	 */
	public ToDoListApplication() {
		super("my To Do List");
		// Instantiate services ...
		// In real world a dependency injection framework
		// like spring would be much better to do this job.
		projectSrv = new ProjectSrvImpl();
		toDoListSrv = new ToDoListSrvImpl(projectSrv);
		toDoListModel = new ArrayListModel<ToDoItemTO>();

		// Instantiate view
		toDoListView = new ToDoListView();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add the Calculator view
		getContentPane().add(toDoListView);

		// Bind components
		doBindComponents();

		// Display the window.
		pack();
		setVisible(true);
	}

	/**
	 * Method does bind the gui components to the data model of this
	 * application.
	 */
	protected void doBindComponents() {
		toDoListView.getAddToDoEntryButton().addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						final AddToDoEntryView view = new AddToDoEntryView(
								ToDoListApplication.this);
						final SelectionInList<ProjectTO> projectAdapter = new SelectionInList<ProjectTO>(
								projectSrv.getAllProjects());
						view.getProjectComboBox().setModel(
								new ComboBoxAdapter<ProjectTO>(projectAdapter));
						view.setVisible(true);
						view.getAddEntryButton().addActionListener(
								new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										StringBuffer validationMessages = new StringBuffer();
										if (view.getDescriptionTextField()
												.getText() == null
												|| view
														.getDescriptionTextField()
														.getText().length() < 1) {
											validationMessages
													.append("Description: The description is empty!\n");
										}
										if (view.getDueDatePicker().getDate() == null) {
											validationMessages
													.append("Due Date: The 'due date' is empty!\n");
										}
										if (projectAdapter.getSelection() == null) {
											validationMessages
													.append("Project: No project is selected!\n");
										}
										if (validationMessages.length() > 0) {
											view
													.getValidationTextArea()
													.setText(
															validationMessages
																	.toString());
										} else {
											ToDoItemTO newEntry = new ToDoItemTO(
													view
															.getDescriptionTextField()
															.getText(), view
															.getDueDatePicker()
															.getDate(), false,
													null, projectAdapter
															.getSelection());
											toDoListModel.clear();
											toDoListModel.addAll(toDoListSrv
													.save(newEntry));

											view.closeDialog();
										}
									}
								});

						// Add action listener for cancel button
						view.getCancelButton().addActionListener(
								new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										view.closeDialog();
									}
								});
					}
				});
		toDoListModel.addAll(toDoListSrv.getAllToDoListItems());
		ToDoListTableModel model = new ToDoListTableModel(toDoListModel);
		toDoListView.getToDoListTable().setModel(model);
		toDoListView.getToDoListTable().setDefaultRenderer(Boolean.class,
				new CheckboxCellRenderer());
		toDoListView.getToDoListTable().setDefaultEditor(Boolean.class,
				new DefaultCellEditor(new JCheckBox()));

		toDoListView.getToDoListTable().setDefaultRenderer(ProjectTO.class,
				new ProjectComboboxCellRenderer());
		toDoListView.getToDoListTable().setDefaultEditor(
				ProjectTO.class,
				new DefaultCellEditor(new JComboBox(projectSrv.getAllProjects()
						.toArray())));

		toDoListView.getToDoListTable().setDefaultEditor(Date.class,
				new DatePickerCellEditor());
	}
}
