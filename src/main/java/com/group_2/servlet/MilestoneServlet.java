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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name ="milestone", urlPatterns = "/milestones")
public class MilestoneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		int project_id;
		try {
			String userName = session.getAttribute("userName").toString();
			if (userName!=null){
				String id = req.getParameter("project_id");

				if (id != null){
					project_id = Integer.parseInt(id);
				}
				else{
					id = session.getAttribute("project_id").toString();
					project_id = Integer.parseInt(id);
				}

				session.setAttribute("project_id",project_id);
				MilestoneList allMilestones= DAO.loadMilestones();
				allMilestones = allMilestones.filter(project_id);

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
		catch (NullPointerException e) {
//			session.setAttribute("next","/milestones");
			resp.sendRedirect("/login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		int project_id;
		try {
			String userName = session.getAttribute("userName").toString();
			if (userName!=null){
				String id = req.getParameter("project_id");

				if (id != null){
					project_id = Integer.parseInt(id);
				}
				else{
					id = session.getAttribute("project_id").toString();
					project_id = Integer.parseInt(id);
				}

				String name = req.getParameter("title");
				String dueDate = req.getParameter("dueDate");
				req.setAttribute("project_id",project_id);

				Milestone milestone = new Milestone(name,project_id);
				milestone.setDueDate(DateParser.toDate(dueDate));

				DAO.addMilestone(milestone);
				MilestoneList allMilestones= DAO.loadMilestones();
				allMilestones = allMilestones.filter(project_id);

				MilestoneList notStarted= allMilestones.getNotStarted();
				MilestoneList inProgress= allMilestones.getInProgress();
				MilestoneList completed= allMilestones.getCompleted();

				req.setAttribute("notStarted",notStarted.getList());
				req.setAttribute("inProgress",inProgress.getList());
				req.setAttribute("completed",completed.getList());

				RequestDispatcher rs = req.getRequestDispatcher("/milestones.jsp");
				rs.include(req, resp);
			}
			else{
				resp.sendRedirect("/login");
			}

		}
		catch (Exception e) {
//			session.setAttribute("next","/milestones");
			resp.sendRedirect("/login");
		}
	}
}
