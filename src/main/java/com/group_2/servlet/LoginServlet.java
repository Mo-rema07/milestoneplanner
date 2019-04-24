package com.group_2.servlet;

import com.group_2.milestonePlanner.auth.UserLogin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/login")
public class LoginServlet  extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		UserLogin userLogin = new UserLogin();
		if(userLogin.login(pass,email))
		{
			RequestDispatcher rs = request.getRequestDispatcher("Welcome");
			rs.forward(request, response);
		}
		else
		{
			out.println("Username or Password incorrect");
			RequestDispatcher rs = request.getRequestDispatcher("/login.html");
			rs.include(request, response);
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rs =request.getRequestDispatcher("/login.html");
		rs.include(request, response);

	}
}

