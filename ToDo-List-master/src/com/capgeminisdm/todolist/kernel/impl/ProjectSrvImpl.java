/**
 * 
 */
package com.capgeminisdm.todolist.kernel.impl;

import com.capgeminisdm.todolist.kernel.ProjectSrv;
import com.capgeminisdm.todolist.kernel.to.ProjectTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * The default implementation of the project service.
 * 
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 */
public class ProjectSrvImpl implements ProjectSrv, Cloneable {
	private HashMap<Integer,ProjectTO> projects=new HashMap<Integer, ProjectTO>();

	public ProjectSrvImpl(){
		initTestData();
	}
	
	/**
	 * Initializes the test data of this service.
	 */
	private void initTestData(){
		projects.put(0,new ProjectTO(0, "none"));
		projects.put(1,new ProjectTO(1, "Selenium Tests"));
		projects.put(2,new ProjectTO(2, "FEST Article"));
		projects.put(3,new ProjectTO(3, "Spring DM"));

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgeminisdm.todolist.kernel.ProjectSrv#getAllProjects()
	 */
	@Override
	public List<ProjectTO> getAllProjects() {
		return new ArrayList<ProjectTO>(projects.values());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgeminisdm.todolist.kernel.ProjectSrv#getProject(java.lang.Integer)
	 */
	@Override
	public ProjectTO getProject(Integer id) {
		if(projects.containsKey(id)){
			return projects.get(id);
		}
		return null;
	}

}
