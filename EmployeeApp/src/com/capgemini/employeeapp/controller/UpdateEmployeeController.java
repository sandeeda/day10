package com.capgemini.employeeapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employeeapp.dao.EmployeeDao;

@WebServlet("/update")
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;
    private ServletContext context;
    
    public UpdateEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		context = config.getServletContext();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		employeeDao = (EmployeeDao) context.getAttribute("employeeDao");
		String id = request.getParameter("id");
		request.setAttribute("employeeDao", employeeDao.findEmployeeById(Integer.parseInt(id)));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateEmployeeDetails.jsp");
		dispatcher.forward(request, response);
		
		
	
	}

}
