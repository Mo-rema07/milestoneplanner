package com.group_2.servlet;

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
	ProjectList projectList = new ProjectList();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("ptitle");
		Project project = new Project(name);
		projectList.put(project);
		req.setAttribute("ProjectList",projectList.getList());
		RequestDispatcher rs = req.getRequestDispatcher("/projects.jsp");
		rs.include(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		Project project = new Project("Project 1");
		Project project1 = new Project("Project 2");
		Project project2 = new Project("Project 3");

		projectList.put(project);
		projectList.put(project1);
		projectList.put(project2);

		req.setAttribute("ProjectList",projectList.getList());
		req.setAttribute("Title", "Landing Page");
		req.setAttribute("test", "test");
		req.setAttribute("project", project);

		RequestDispatcher rs = req.getRequestDispatcher("/projects.jsp");
		rs.include(req, resp);

	}
}

