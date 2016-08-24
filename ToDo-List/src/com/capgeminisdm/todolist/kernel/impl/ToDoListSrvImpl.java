/*
CapgeminiSdmFestSample Application File
User: ddary
$Date: 2007/07/13 08:17:07 $
$Revision: 1.1 $
 */
package com.capgeminisdm.todolist.kernel.impl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.capgeminisdm.todolist.kernel.ProjectSrv;
import com.capgeminisdm.todolist.kernel.ToDoListSrv;
import com.capgeminisdm.todolist.kernel.to.ToDoItemTO;

/**
 * The default ToDo List service implementation.
 * 
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 */
public class ToDoListSrvImpl implements ToDoListSrv {
	private ProjectSrv projectSrv;

	private List<ToDoItemTO> items = new ArrayList<ToDoItemTO>();

	public ToDoListSrvImpl(ProjectSrv projectSrv) {
		this.projectSrv = projectSrv;
		initTestData();
	}

	/**
	 * Initializes the test data of this service.
	 */
	private void initTestData() {
		items.add(new ToDoItemTO("Create a layer figure",
				new GregorianCalendar(2009, 10, 12).getTime(), false, 0,
				projectSrv.getProject(2)));
		items.add(new ToDoItemTO("Create tests component A",
				new GregorianCalendar(2009, 9, 25).getTime(), false, 1,
				projectSrv.getProject(1)));
		items.add(new ToDoItemTO("Create tests component B",
				new GregorianCalendar(2009, 9, 20).getTime(), true, 2,
				projectSrv.getProject(1)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgeminisdm.todolist.kernel.ToDoListSrv#getAllToDoListItems()
	 */
	@Override
	public List<ToDoItemTO> getAllToDoListItems() {
		return items;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgeminisdm.todolist.kernel.ToDoListSrv#save(java.util.List)
	 */
	@Override
	public List<ToDoItemTO> save(ToDoItemTO item) {
		assert item != null : "The toDoItem must not be null";
		// This implementation is not very elegant, but
		// for this demo project it is ok.
		item.setId(items == null ? 0 : items.size() + 1);
		
		//Add new item to the list of items, here normally a
		// DAO call would be done.
		items.add(item);
		
		return getAllToDoListItems();
	}
}
