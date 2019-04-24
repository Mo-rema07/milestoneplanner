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


@WebServlet( name = "ProjectServlet" ,urlPatterns = "/")
public class ProjectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ProjectList projectList = new ProjectList();

		Project project = new Project("Project 1");
		Project project1 = new Project("Project 2");
		Project project2 = new Project("Project 3");

		projectList.put(project);
		projectList.put(project1);
		projectList.put(project2);

		req.setAttribute("ProjectList",projectList);
		req.setAttribute("Title", "Landing Page");
		req.setAttribute("test", "test");
		req.setAttribute("project", project);
		RequestDispatcher rs = req.getRequestDispatcher("/index.jsp");
		rs.forward(req, resp);
	}
}
