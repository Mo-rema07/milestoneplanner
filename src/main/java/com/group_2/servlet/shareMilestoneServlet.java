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
import java.sql.Date;

@SuppressWarnings("Duplicates")
@WebServlet(name="shareMilestone", urlPatterns = "/share")
public class shareMilestoneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		try {
			String userName = session.getAttribute("userName").toString();
			if (userName!=null){
				MilestoneList milestonesList = DAO.loadMilestones();
				String name = req.getParameter("milestone_id");
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

				RequestDispatcher rs = req.getRequestDispatcher("/shared.jsp");
				rs.include(req, resp);
			}
			else{
				resp.sendRedirect("/login");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/login");
		}

	}
}
