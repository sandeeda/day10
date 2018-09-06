package com.capgemini.employeeapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.employeeapp.dao.EmployeeDao;
import com.capgemini.employeeapp.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	
	private ArrayList<Employee> employees = new ArrayList<>();
	
	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public Employee findEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		for (Employee employee : employees) {
			if(employee.getEmployeeId()==employeeId)
			{
				return employee;
			}
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		for (Employee employee : employees) {
			if(employee.getEmployeeId()==employeeId)
			{
				employees.remove(employee);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employees.add(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		for (Employee employeeIter : employees) {
			if(employeeIter.getEmployeeId()==employee.getEmployeeId())
					{
						employeeIter=employee;
					}
		}
		return null;
	}

}
