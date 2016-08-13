package com.capgeminisdm.todolist.kernel.to;

/**
 * Transfer object represents a project.
 * 
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 *
 */
public class ProjectTO {
	private Integer id;

	private String name;

	public ProjectTO(){
	}

	public ProjectTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}
}
