package com.group_2.milestonePlanner.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Milestone {
	private boolean isComplete;
	private boolean hasStarted;
	private String name;
	private Date dueDate;
	private Date completionDate;

	public Milestone(String name, Date dueDate) {
		this.isComplete = false;
		this.hasStarted = false;
		this.name = name;
		this.dueDate = dueDate;
	}

	public Milestone(String name) {
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

	public String getDueDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(this.dueDate);
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setDueDate(String dueDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;
		try {
			utilDate = formatter.parse(dueDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.dueDate = new Date(utilDate.getTime());
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
}

//TODO: Signup message
// TODO:Sign up
//TODO:	delete edit and share
//TODO:	change when logging to lead you to projects
//TODO:	Rethabile check boxes for progress
//TODO:		find a way to share a database
//TODO:		link projects to users and milestones to projects