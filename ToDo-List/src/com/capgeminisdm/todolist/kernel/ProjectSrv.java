package com.capgeminisdm.todolist.kernel;

import java.util.List;

import com.capgeminisdm.todolist.kernel.to.ProjectTO;

/**
 * Service for handling projects.
 * 
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 * 
 */
public interface ProjectSrv {
	/**
	 * Returns a list of all available projects.
	 * 
	 * @return List of projects.
	 */
	public List<ProjectTO> getAllProjects();

	/**
	 * Returns the project of the given id.
	 * 
	 * @param id
	 *            The project id.
	 * @return The project of the given id, otherwise null.
	 */
	public ProjectTO getProject(Integer id);
}
