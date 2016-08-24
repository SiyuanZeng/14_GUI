package com.capgeminisdm.todolist.application;

import java.awt.Color;

import javax.swing.JDialog;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.data.TableCell;
import org.fest.swing.data.TableCell.TableCellBuilder;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.finder.DialogFinder;
import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JTableCellFixture;
import org.fest.swing.fixture.JTableFixture;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXTable;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.fest.swing.data.TableCell.row;

import com.capgeminisdm.todolist.client.application.ToDoListApplication;
import com.capgeminisdm.todolist.fest.fixture.JXDatePickerFixture;
import com.sun.rowset.internal.Row;

/*
 CapgeminiSdmFestSample Application File
 User: ddary
 $Date: 2007/07/13 08:17:07 $
 $Revision: 1.1 $
 */

/**
 * The FEST test to test the swing gui.
 * 
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 * 
 */
public class ToDoListViewTest extends TestCase {
	private FrameFixture window;

	/**
	 * Tests editing cells of the todo list table.
	 */
	@Test
	public void testTableEditing() {

		// Find table GUI component
		JTableFixture taskTable = window.table("toDoListTable");

		// Selecting the finish cell
		JTableCellFixture finishedCell = taskTable.cell(row(0).column(2));

		// Selecting the checkbox
		finishedCell.enterValue("true");
		finishedCell.background().requireEqualTo(Color.GREEN);

		// Selecting the project cell
		JTableCellFixture projectCell = taskTable.cell(row(0).column(3));

		// Select a value in the comboBox
		projectCell.enterValue("Spring DM");

		// Assert the selected value is displayed afterwards
		projectCell.requireValue("Spring DM");
	}

	/**
	 * Tests adding a todo enty to the todo list table.
	 */
	@Test
	public void testAddEntry() {
		JButtonFixture addButton = window.button("addToDoEntryButton");

		addButton.click();

		DialogFixture addItemDialog = window.dialog();

		// Enter description
		addItemDialog.textBox("descriptionTextField").enterText("Hello FEST!");

		// Enter due date
		new JXDatePickerFixture(addItemDialog.robot, "dueDatePicker",
				JXDatePicker.class).enterText("20.10.2009");

		// select a project
		addItemDialog.comboBox("projectComboBox").selectItem("Spring DM");

		// click the button "add entry"
		addItemDialog.button("addEntryButton").click();

		// After clicking the "add entry" button the dialog was closed.
		addItemDialog.requireNotVisible();

		// Find table GUI component
		JTableFixture taskTable = window.table("toDoListTable");
		Assert.assertEquals(4, taskTable.rowCount());

		// Selecting the description
		JTableCellFixture descriptionCell = taskTable.cell(row(3).column(0));
		descriptionCell.requireValue("Hello FEST!");

		// Selecting the due date
		JTableCellFixture dueDateCell = taskTable.cell(row(3).column(1));
		dueDateCell.requireValue("20.10.2009");

		// Selecting the finish cell
		JTableCellFixture finishedCell = taskTable.cell(row(3).column(2));
		Assert.assertEquals("false", finishedCell.value());
		finishedCell.background().requireEqualTo(Color.RED);

		// Selecting the project cell
		JTableCellFixture projectCell = taskTable.cell(row(3).column(3));
		projectCell.requireValue("Spring DM");

	}

	/**
	 * @see org.fest.swing.junit.testcase.FestSwingJUnitTestCase#onSetUp()
	 */
	protected void setUp() {
		window = new FrameFixture(new ToDoListApplication());
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	public void tearDown() {
		window.cleanUp();
	}

	/**
	 * Install FailOnThreadViolationRepaintManager to check that all access to
	 * Swing components is performed in the EDT.
	 */
	@BeforeClass
	public static void mySetUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

}
