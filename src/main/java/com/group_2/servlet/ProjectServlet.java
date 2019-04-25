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
import java.io.IOException;


@WebServlet( name = "projects" ,urlPatterns = "/projects")
public class ProjectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		String name = req.getParameter("ptitle");
		Project project = new Project(name);
		DAO.addProject(project);

		ProjectList projectList = DAO.loadProjects();
		req.setAttribute("ProjectList",projectList.getList());

		RequestDispatcher rs = req.getRequestDispatcher("/projects.jsp");
		rs.include(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ProjectList projectList = DAO.loadProjects();

		req.setAttribute("ProjectList",projectList.getList());

		RequestDispatcher rs = req.getRequestDispatcher("/projects.jsp");
		rs.include(req, resp);

	}
}
