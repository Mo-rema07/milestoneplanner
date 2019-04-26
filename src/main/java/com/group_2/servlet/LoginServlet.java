package com.group_2.servlet;

import com.group_2.milestonePlanner.auth.UserLogin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name ="login" ,urlPatterns = "/login")
public class LoginServlet  extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("user");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		HttpSession session;
		if (email != null) {
			UserLogin.register(name,pass,email);
			session = request.getSession();
			response.sendRedirect("/projects");
		} else {
			if(UserLogin.login(name,pass))
			{
				session= request.getSession();
				session.setAttribute("userName", name);
				response.sendRedirect("/projects");
			}
			else
			{
				out.println("Username or Password incorrect");
				RequestDispatcher rs = request.getRequestDispatcher("/login.jsp");
				rs.include(request, response);
			}
		}


	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rs =request.getRequestDispatcher("/login.jsp");
		rs.include(request, response);

	}
}

