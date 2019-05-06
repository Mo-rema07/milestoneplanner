package com.group_2.servlet;

import com.group_2.milestonePlanner.dao.DAO;
import com.group_2.milestonePlanner.model.Project;
import com.group_2.milestonePlanner.repo.ProjectList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet( name = "projects" ,urlPatterns = "/projects")
public class ProjectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession session = req.getSession(true);

		try {
			String userName = session.getAttribute("userName").toString();
			int userId = (int) session.getAttribute("userId");
			if (userName!=null){
				String name = req.getParameter("ptitle");
				Project project = new Project(name,userId);
				DAO.addProject(project);
				System.out.println(userId);
				ProjectList projectList = DAO.loadProjects();
				req.setAttribute("ProjectList",projectList.getList(userId));


				RequestDispatcher rs = req.getRequestDispatcher("/projects.jsp");
				rs.include(req, resp);
			}
			else{
				resp.sendRedirect("/login");
			}

		}
		catch (Exception e) {
			resp.sendRedirect("/login");
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		try {
			String userName = session.getAttribute("userName").toString();
			int userId = (int) session.getAttribute("userId");
			if (userName!=null){
				ProjectList projectList = DAO.loadProjects();

				req.setAttribute("ProjectList",projectList.getList(userId));

				RequestDispatcher rs = req.getRequestDispatcher("/projects.jsp");
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
