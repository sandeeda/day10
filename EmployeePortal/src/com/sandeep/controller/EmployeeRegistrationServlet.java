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

@WebServlet("/registration")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private HashMap<String, Employee> empData = new HashMap<>();  

	public EmployeeRegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		context=config.getServletContext();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String empid=request.getParameter("empid");
		String salary = request.getParameter("salary");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");


		if(empData.containsKey(empid))
		{
		
			out.println("<p>Sorry! Employee already exists");
			out.println("<br><br><a href='registration.html'>Try Again</a>");

		}
		else
		{
			empData.put(empid, new Employee(empid,name,salary,dept));
			out.println("<h1>account created</h1>");
			out.println("<br><br><a href='employeeIndex.html'>Login Here</a>");
			context.setAttribute("empData", empData);
		}
		out.close();
	}

}
