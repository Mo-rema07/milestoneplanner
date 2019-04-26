package com.group_2.milestonePlanner.model;

import com.group_2.milestonePlanner.dao.DAO;

import java.util.ArrayList;

public class Project {
	private int project_id;
	private String name;
	private int ownerId;
	private ArrayList<Milestone> milestones = new ArrayList<>();
	private double progress = 0;

	private static int next_project_id = DAO.lastProjectId()+1;

	public Project(int project_id, String name, int ownerId) {
		this.project_id = project_id;
		this.name = name;
		this.ownerId = ownerId;
	}

	public Project(String name) {
		this.name = name;
		this.project_id = next_project_id;
		next_project_id++;
	}

	public Project(String name, int ownerId) {
		this.name = name;
		this.ownerId = ownerId;
		this.project_id = next_project_id;
		next_project_id++;
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

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public static int getNext_project_id() {
		return next_project_id;
	}

	public static void setNext_project_id(int next_project_id) {
		Project.next_project_id = next_project_id;
	}
}
