package com.sandeep.bank.dao.impl;

import java.util.HashSet;

import com.sandeep.bank.dao.CustomerDao;
import com.sandeep.bank.database.DataBase;
import com.sandeep.bank.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private HashSet<Customer> customerData;
	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub
		customerData=DataBase.getAllCustomerData();

	}

	@Override
	public Customer authenticate(Customer customer) {
		// TODO Auto-generated method stub
		for (Customer customer2 : customerData) {
			if(customer2.getCustomerId()==customer.getCustomerId())
			{
				if(customer2.getPassword().equals(customer.getPassword()))
				{
					return customer2;
				}
			}
		}
		return null;
	}

	@Override
	public Customer updateProfile(Customer customer) {
		// TODO Auto-generated method stub
		for (Customer customer2 : customerData) {
			if(customer2.getCustomerId()==customer.getCustomerId())
			{
				customer2.setAddress(customer.getAddress());
				System.out.println(customer.getAddress());
				customer2.setEmail(customer.getEmail());
				return customer2;
			}
		}
		return null;
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		for (Customer customer2 : customerData) {
			if(customer2.getCustomerId()==customer.getCustomerId())
			{
				if(customer2.getPassword().equals(oldPassword))
				{
					customer2.setPassword(newPassword);
					return true;
				}
			}
		}
		return false;
	}

}
