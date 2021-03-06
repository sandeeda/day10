package com.sandeep.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private ServletContext context;
      private HashMap<String, String> users = new HashMap<>();
   
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		context=config.getServletContext();
		context.setAttribute("usersData", users);
	}
	
    public LoginServlet() {
        super();
    }


	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		users= (HashMap<String, String>) context.getAttribute("usersData");
		
		
		
		if(users.containsKey(username))
		{
			if(users.get(username).equals(password))
					out.println("<h1>yahooooooooooooo.....u have successfully logged in</h1>");
			else
			{
				out.println("<h3>wrong password.   Please <a href='login.html'>try again</a></h3>");
			}
		}
		else
		{
			out.println("<h3>user does not exist.   Please <a href='registration.html'>sign up</a></h3>");
		}
	
		out.close();
	}

}
