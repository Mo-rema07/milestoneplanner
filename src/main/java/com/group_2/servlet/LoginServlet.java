package com.group_2.servlet;

import com.group_2.milestonePlanner.auth.UserLogin;
import com.group_2.milestonePlanner.dao.DAO;
import com.group_2.milestonePlanner.repo.UserList;

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

			UserList users = DAO.loadUsers();
			int user_id = users.getUser(name).getUser_id();

			session = request.getSession();
			session.setAttribute("userName", name);
			session.setAttribute("userId", user_id);
			response.sendRedirect("/projects");
		} else {
			if(UserLogin.login(name,pass))
			{
				UserList users = DAO.loadUsers();
				int user_id = users.getUser(name).getUser_id();

				session= request.getSession();
				session.setAttribute("userName", name);
				session.setAttribute("userId", user_id);
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

