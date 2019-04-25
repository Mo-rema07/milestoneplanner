package com.group_2.milestonePlanner.repo;

import com.group_2.milestonePlanner.model.Milestone;
import com.group_2.milestonePlanner.model.Project;

import java.util.ArrayList;

public class MilestoneList {

	private ArrayList<Milestone> list;

	public MilestoneList(){
		this.list = new ArrayList<>();
	}

	public ArrayList<Milestone> getList() {
		return list;
	}

	public void put(Milestone milestone){
		list.add(milestone);
	}

}
