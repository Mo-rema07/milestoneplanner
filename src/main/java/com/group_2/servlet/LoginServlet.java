package com.group_2.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import main.java.com.group_2.util.Validate;

public class LoginServlet  extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		if(Validate.checkUser(email, pass))
		{
			RequestDispatcher rs = request.getRequestDispatcher("Welcome");
			rs.forward(request, response);
		}
		else
		{
			out.println("Username or Password incorrect");
			RequestDispatcher rs = request.getRequestDispatcher("index.html");
			rs.include(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		if(Validate.checkUser(email, pass))
		{
			RequestDispatcher rs = request.getRequestDispatcher("Welcome");
			rs.forward(request, response);
		}
		else
		{
			out.println("Username or Password incorrect");
			RequestDispatcher rs = request.getRequestDispatcher("login.html");
			rs.include(request, response);
		}
	}
}

