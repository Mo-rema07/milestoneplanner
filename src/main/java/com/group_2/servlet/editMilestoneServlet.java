package com.group_2.servlet;

import com.group_2.milestonePlanner.dao.DAO;
import com.group_2.milestonePlanner.model.Milestone;
import com.group_2.milestonePlanner.repo.MilestoneList;
import com.group_2.util.DateParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name="editMilestone", urlPatterns = "/edit")
public class editMilestoneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MilestoneList milestonesList = DAO.loadMilestones();
		String name = req.getParameter("id");
		Milestone milestone = new Milestone(name);
		for (Milestone m : milestonesList.getList()){
			if(m.getName().equals(name)){
				milestone = m;
			}
		}

		String dueDate = DateParser.toString(milestone.getDueDate());
		Date date = milestone.getCompletionDate();
		String completionDate;

		if (date != null){
			completionDate = DateParser.toString(date);
		}
		else{
			completionDate = null;
		}


		req.setAttribute("m", milestone);
		req.setAttribute("dueDate", dueDate);
		req.setAttribute("completionDate", completionDate);

		RequestDispatcher rs = req.getRequestDispatcher("/edit.jsp");
		rs.include(req, resp);


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String initialName = req.getParameter("id");
		String dueDate = req.getParameter("dueDate");
		String completionDate = req.getParameter("completionDate");
		boolean isComplete = Boolean.parseBoolean(req.getParameter("complete"));
		boolean hasStarted = Boolean.parseBoolean(req.getParameter("started"));

		Milestone milestone = new Milestone(isComplete,hasStarted,name);
		milestone.setDueDate(DateParser.toDate(dueDate));
		milestone.setCompletionDate(DateParser.toDate(completionDate));

		DAO.updateMilestone(milestone, initialName);
		resp.sendRedirect("/milestones");

	}
}
