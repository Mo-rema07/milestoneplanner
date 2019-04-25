package com.group_2.servlet;

import com.group_2.milestonePlanner.dao.DAO;
import com.group_2.milestonePlanner.model.Milestone;
import com.group_2.milestonePlanner.model.Project;
import com.group_2.milestonePlanner.repo.MilestoneList;
import com.group_2.milestonePlanner.repo.ProjectList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name ="milestone", urlPatterns = "/milestones")
public class MilestoneServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MilestoneList allMilestones= DAO.loadMilestones();

		MilestoneList notStarted= allMilestones.getNotStarted();
		MilestoneList inProgress= allMilestones.getInProgress();
		MilestoneList completed= allMilestones.getCompleted();

		req.setAttribute("notStarted",notStarted.getList());
		req.setAttribute("inProgress",inProgress.getList());
		req.setAttribute("completed",completed.getList());

		RequestDispatcher rs = req.getRequestDispatcher("/milestones.jsp");
		rs.include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("title");
		String dueDate = req.getParameter("dueDate");
		Milestone milestone = new Milestone(name);
		milestone.setDueDate(dueDate);

		DAO.addMilestone(milestone);
		MilestoneList allMilestones= DAO.loadMilestones();

		MilestoneList notStarted= allMilestones.getNotStarted();
		MilestoneList inProgress= allMilestones.getInProgress();
		MilestoneList completed= allMilestones.getCompleted();

		req.setAttribute("notStarted",notStarted.getList());
		req.setAttribute("inProgress",inProgress.getList());
		req.setAttribute("completed",completed.getList());

		RequestDispatcher rs = req.getRequestDispatcher("/milestones.jsp");
		rs.include(req, resp);
	}
}
