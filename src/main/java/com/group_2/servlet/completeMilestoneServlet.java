package com.group_2.servlet;

import com.group_2.milestonePlanner.dao.DAO;
import com.group_2.milestonePlanner.model.Milestone;
import com.group_2.milestonePlanner.repo.MilestoneList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="completeStatus", urlPatterns = "/isComplete")
public class completeMilestoneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MilestoneList allMilestones= DAO.loadMilestones();
		String name = req.getParameter("id");
		boolean state = Boolean.parseBoolean(req.getParameter("to"));
		for (Milestone m : allMilestones.getList()){
			if (m.getName().equals(name)){
				m.setComplete(state);
				DAO.updateMilestone(m,name);

			}
		}
		DAO.loadMilestones();
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
