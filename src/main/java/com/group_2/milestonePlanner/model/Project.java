package com.group_2.milestonePlanner.model;

import java.util.ArrayList;

public class Project {
	User owner;
	ArrayList<Milestone> milestones;
	double progress;

	public Project(User owner, double progress) {
		this.owner = owner;
		this.milestones = new ArrayList<>();
		this.progress = progress;
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
