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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="completeStatus", urlPatterns = "/isComplete")
public class completeMilestoneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		try {
			String userName = session.getAttribute("userName").toString();
//			int project_id = Integer.parseInt(req.getParameter("project_id"));
//			req.setAttribute("project_id",project_id);
			if (userName!=null){
				MilestoneList allMilestones= DAO.loadMilestones();
				String name = req.getParameter("milestone_id");
				boolean state = Boolean.parseBoolean(req.getParameter("to"));
				for (Milestone m : allMilestones.getList()){
					if (m.getName().equals(name)){
						m.setComplete(state);
						DAO.updateMilestone(m,name);

					}
				}
				resp.sendRedirect("/milestones");

			}
			else{
				resp.sendRedirect("/login");
			}
		}
		catch (Exception e ) {
			e.printStackTrace();
			resp.sendRedirect("/login");
		}
	}
}
