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

	public  ArrayList<Project> getList(int owner_id){
		ArrayList<Project> newList = new ArrayList<>();
		for (Project project: list){
			if (project.getOwnerId()==owner_id){
				newList.add(project);
			}
		}
		return newList;
	}
}
