package com.capgemini.employeeapp.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.capgemini.employeeapp.dao.impl.EmployeeDaoImpl;
import com.capgemini.employeeapp.model.Employee;

@WebServlet("/addEmployee")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;  
    private ServletContext context;


    public AddEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
        employeeDao = new EmployeeDaoImpl();
    }

    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	context = config.getServletContext();
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    			int empId=Integer.parseInt(request.getParameter("empId"));
    			String empName = request.getParameter("empName");
    			double empSalary=Double.parseDouble(request.getParameter("empSalary"));
    			String empDept= request.getParameter("empDepartment");
    			
    			context.setAttribute("employeeDao", employeeDao);
    			RequestDispatcher dispatcher = null;
    			
    			Employee employee = new Employee(empId, empName, empSalary, empDept);
    			
    			if(employeeDao.addEmployee(employee))
    			{
    				 response.sendRedirect("getAllEmployees");
    			}
    			else
    			{
    				dispatcher = request.getRequestDispatcher("error.jsp");
    				dispatcher.forward(request, response);
    				
    			}
    }
/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		double empSalary=Double.parseDouble(request.getParameter("empSalary"));
		String empDept= request.getParameter("empDepartment");
		
		Employee employee= new Employee(empId, empName, empSalary, empDept);
		employeeDao = (EmployeeDao) context.getAttribute("employeeDao");
		employeeDao.updateEmployee(employee);
		
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList=employeeDao.findAllEmployees();
		request.setAttribute("employeesList", employeesList);
		
		
		context.setAttribute("employeeDao", employeeDao);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("displayAllEmployeeDetails.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
	}
*/
}
