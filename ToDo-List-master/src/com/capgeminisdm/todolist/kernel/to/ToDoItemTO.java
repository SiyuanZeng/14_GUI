package com.capgeminisdm.todolist.kernel.to;

import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 * Transfer object represents a toDo item.
 * 
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 */
public class ToDoItemTO {
	private String description;
	private Date dueDate;
	private Boolean finished;
	private Integer id;
	private ProjectTO project;
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(
			this);

	public ToDoItemTO() {
	}

	public ToDoItemTO(String description, Date dueDate, Boolean finished,
			Integer id, ProjectTO project) {
		super();
		this.description = description;
		this.dueDate = dueDate;
		this.finished = finished;
		this.id = id;
		this.project = project;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @return the finished
	 */
	public Boolean getFinished() {
		return finished;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the project
	 */
	public ProjectTO getProject() {
		return project;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		String oldValue = this.description;
		this.description = description;
		changeSupport.firePropertyChange("description", oldValue, description);
	}

	/**
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		Date oldValue = this.dueDate;
		this.dueDate = dueDate;
		changeSupport.firePropertyChange("description", oldValue, dueDate);
	}

	/**
	 * @param finished
	 *            the finished to set
	 */
	public void setFinished(Boolean finished) {
		Boolean oldValue = this.finished;
		this.finished = finished;
		changeSupport.firePropertyChange("description", oldValue, finished);
	}
	
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		Integer oldValue = this.id;
		this.id = id;
		changeSupport.firePropertyChange("id", oldValue, id);
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(ProjectTO project) {
		ProjectTO oldValue = this.project;
		this.project = project;
		changeSupport.firePropertyChange("description", oldValue, project);
	}
}
