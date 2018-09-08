package com.capgemini.employeeapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employeeapp.dao.EmployeeDao;
import com.capgemini.employeeapp.model.Employee;


@WebServlet("/getAllEmployees")
public class GetAllEmployeeDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao; 
    private ServletContext context;
    public GetAllEmployeeDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		context = config.getServletContext();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeeDao = (EmployeeDao) context.getAttribute("employeeDao");
		List<Employee> employees = employeeDao.findAllEmployees();
		request.setAttribute("employeesList", employees);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("displayAllEmployeeDetails.jsp");
		dispatcher.forward(request, response);
		
	}

}
