package com.group_2.servlet;

import com.group_2.milestonePlanner.model.Project;
import com.group_2.milestonePlanner.repo.ProjectList;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "welcome", urlPatterns = "/welcome")
public class Welcome extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("Welcome user");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ProjectList projectList = new ProjectList();

		Project project = new Project("Project 1");
		Project project1 = new Project("Project 2");
		Project project2 = new Project("Project 3");

		projectList.put(project);
		projectList.put(project1);
		projectList.put(project2);

		request.setAttribute("ProjectList",projectList.getList());
		request.setAttribute("Title", "Landing Page");
		request.setAttribute("test", "test");
		request.setAttribute("project", project);
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
		rs.forward(request, response);
	}
}