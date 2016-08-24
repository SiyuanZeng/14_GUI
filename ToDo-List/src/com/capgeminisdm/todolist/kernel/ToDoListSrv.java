/*
CapgeminiSdmFestSample Application File
User: ddary
$Date: 2007/07/13 08:17:07 $
$Revision: 1.1 $
 */
package com.capgeminisdm.todolist.kernel;

import java.util.List;

import com.capgeminisdm.todolist.kernel.to.ToDoItemTO;

/**
 * Service for handling to do list items.
 * 
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 */
public interface ToDoListSrv {

	/**
	 * Returns all to do list entries that are not yet finished.
	 * @return A list of {@link ToDoItemTO}.
	 */
	public List<ToDoItemTO> getAllToDoListItems();

	/**
	 * Saves the given {@link ToDoItemTO}.
	 * @param item The item to save.
	 * @return The return of {@link #getAllToDoListItems()}
	 */
	public List<ToDoItemTO> save(ToDoItemTO item);
}
