package com.group_2.milestonePlanner.model;

import java.sql.Date;

public class Milestone {
	private boolean isComplete;
	private boolean hasStarted;
	private String name;
	private Date dueDate;
	private Date completionDate;

	public Milestone(boolean isComplete, String name, Date dueDate) {
		this.isComplete = isComplete;
		this.name = name;
		this.dueDate = dueDate;
		this.completionDate = null;
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
