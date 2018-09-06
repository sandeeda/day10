package com.capgemini.employeeapp.controller;

import java.io.IOException;
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
    private EmployeeDao employeeDao = new EmployeeDaoImpl();  


    public AddEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }


    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		double empSalary=Double.parseDouble(request.getParameter("empSalary"));
		String empDept= request.getParameter("empdept");
		
		
		Employee employee = new Employee(empId, empName, empSalary, empDept);
		
		if(employeeDao.addEmployee(employee))
		{
			//success logic
		}
		else
		{
			//fail logic
		}
	}

}
