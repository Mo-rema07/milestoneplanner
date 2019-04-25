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

	public MilestoneList getInProgress(){
		MilestoneList inProgress = new MilestoneList();
		for (Milestone m: list){
			if (m.hasStarted() && !m.isComplete()){
				inProgress.put(m);
			}
		}
		return inProgress;
	}

	public MilestoneList getCompleted(){
		MilestoneList completed = new MilestoneList();
		for (Milestone m: list){
			if (m.hasStarted() && m.isComplete()){
				completed.put(m);
			}
		}
		return completed;
	}

	public MilestoneList getNotStarted(){
		MilestoneList notStarted = new MilestoneList();
		for (Milestone m: list){
			if (!m.hasStarted()){
				notStarted.put(m);
			}
		}
		return notStarted;
	}

}
