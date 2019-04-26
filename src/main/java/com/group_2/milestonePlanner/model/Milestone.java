package com.group_2.milestonePlanner.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Milestone {
	private boolean isComplete = false;
	private boolean hasStarted =false;
	private String name;
	private Date dueDate;
	private Date completionDate;
	private int project_id;

	public Milestone(boolean isComplete, boolean hasStarted, String name, int project_id) {
		this.isComplete = isComplete;
		this.hasStarted = hasStarted;
		this.name = name;
		this.project_id = project_id;
	}

	public Milestone(String name, Date dueDate) {
		this.isComplete = false;
		this.hasStarted = false;
		this.name = name;
		this.dueDate = dueDate;
	}

	public Milestone(String name) {
		this.name = name;
	}

	public Milestone(boolean isComplete, boolean hasStarted, String name,
					 Date dueDate, Date completionDate, int project_id) {
		this.isComplete = isComplete;
		this.hasStarted = hasStarted;
		this.name = name;
		this.dueDate = dueDate;
		this.completionDate = completionDate;
		this.project_id = project_id;
	}

	public Milestone(boolean isComplete, boolean hasStarted, String name) {
		this.isComplete=isComplete;
		this.hasStarted=hasStarted;
		this.name = name;
	}

	public boolean hasStarted() {
		return hasStarted;
	}

	public void setHasStarted(boolean hasStarted) {
		this.hasStarted = hasStarted;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean complete) {
		isComplete = complete;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public boolean isHasStarted() {
		return hasStarted;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}



	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}



	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
}

//TODO: Signup message
//TODO:	delete edit and share
//TODO:	Rethabile check boxes for progress
//TODO: find a way to share a project
//TODO:	link projects to users and milestones to projects
//TODO:	Session Management
//TODO: Progress Bar