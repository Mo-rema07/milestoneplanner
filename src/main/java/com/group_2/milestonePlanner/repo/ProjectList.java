package com.group_2.milestonePlanner.repo;

import com.group_2.milestonePlanner.model.Project;

import java.util.ArrayList;

public class ProjectList {
	private ArrayList<Project> list;

	public ProjectList(){
		this.list = new ArrayList<>();
	}

	public void put(Project project){
		list.add(project);
	}

	public ArrayList<Project> getList(){
		return list;
	}
}
