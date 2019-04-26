package com.group_2.milestonePlanner.model;

import java.util.ArrayList;

public class Project {
	private String name;
	private int ownerId;
	private ArrayList<Milestone> milestones = new ArrayList<>();
	private double progress = 0;

	public Project(String name) {
		this.name = name;
	}

	public Project(String name, int ownerId) {
		this.name = name;
		this.ownerId = ownerId;
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

	public int getOwnerId() {
		return ownerId;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Milestone> getMilestones() {
		return milestones;
	}

	public double getProgress() {
		return progress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMilestones(ArrayList<Milestone> milestones) {
		this.milestones = milestones;
	}

	public void setProgress(double progress) {
		this.progress = progress;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
}
