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


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, String> credentials = new HashMap<>();
    private ServletContext context;
    public RegistrationServlet() {
        super();
    }

    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	context = config.getServletContext();
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		
		
		if(credentials.containsKey(username))
		{
			out.println("<h3>sorry! username is not available . Please try with something more boring</h3>");
			out.println("<br><br><a href='registration.html'>Try Again</a>");
		}
		else {
		credentials.put(username, password);
		out.println("<h1>account created</h1>");
		out.println("<br><br><a href='login.html'>Login Here</a>");
		context.setAttribute("usersData", credentials);

		}
		
		
		
		out.close();
		
	}

}
