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

import com.sandeep.domain.Employee;


@WebServlet("/login")
public class EmployeeIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	HashMap<String, Employee> empData = new HashMap<>();
	

       
  
    public EmployeeIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	context= config.getServletContext();
    	context.setAttribute("empData", empData);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String empid=request.getParameter("empid");
		
		empData=(HashMap<String, Employee>) context.getAttribute("empData");
	
		if(empData.containsKey(empid))
		{
			out.println("<h1>"+empData.get(empid)+"</h1>");
			
		}
		else
		{
			out.println("<h1> employee not found!   go to <a href='registration.html'>registration page</a>");
		}
		out.close();
	}
	

}
