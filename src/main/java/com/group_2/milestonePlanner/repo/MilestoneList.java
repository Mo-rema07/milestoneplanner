package com.group_2.milestonePlanner.repo;

import com.group_2.milestonePlanner.model.Milestone;

import java.util.ArrayList;

public class MilestoneList {
	private ArrayList<Milestone> list;

	public ArrayList<Milestone> getList() {
		return list;
	}

	public void put(Milestone milestone){
		list.add(milestone);
	}
}
