package com.group_2.servlet;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name ="milestone", urlPatterns = "/milestone")
public class MilestoneServlet extends HttpServlet {

	MilestoneList milestoneList= new MilestoneList();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);

		Milestone milestone = new Milestone("first");


		milestoneList.put(milestone);

		req.setAttribute("MilestoneList",milestoneList.getList());

		RequestDispatcher rs = req.getRequestDispatcher("/milestones.jsp");
		rs.include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);


		Milestone milestone = new Milestone("first");

		milestoneList.put(milestone);

		req.setAttribute("MilestoneList",milestoneList.getList());

		RequestDispatcher rs = req.getRequestDispatcher("/milestones.jsp");
		rs.include(req, resp);
	}


}
