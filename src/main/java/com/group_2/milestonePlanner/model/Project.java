package com.group_2.milestonePlanner.model;

import java.util.ArrayList;

public class Project {
	String name;
	User owner;
	ArrayList<Milestone> milestones;
	double progress;

	public Project(User owner, String name) {
		this.name = name;
		this.owner = owner;
		this.milestones = new ArrayList<>();
		this.progress = 0;
	}

	public Project(String name) {
		this.name = name;
	}

	public void addMilestone(Milestone milestone){
		this.milestones.add(milestone);
		updateProgress();
	}

	private void updateProgress(){
		int complete = 0;
		for (Milestone m : milestones){
			if (m.isComplete()){
				complete++;
			}
		}
		this.progress = (double) complete/ (double) milestones.size();
	}
}
