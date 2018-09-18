/*package com.sandeep.bank.dao.impl;

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
				if(customer2.getPassword()==customer.getPassword())
				{
					customer2.setPassword(newPassword);
					return true;
				}
			}
		}
		return false;
	}

}
 */







package com.sandeep.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;

import com.sandeep.bank.dao.CustomerDao;
import com.sandeep.bank.database.DataBase;
import com.sandeep.bank.model.BankAccount;
import com.sandeep.bank.model.Customer;
import com.sandeep.bank.util.DbUtil;

public class CustomerDaoImpl implements CustomerDao {

	private String getCustomerData="select * from customerData";
	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public Customer authenticate(Customer customer) {
		String getCustomer="select * from customerdata where customerId=? and password=?";
		String getBankData="select * from bankdata where accountId=?"; 
		Customer authenticatedCustomer = null;
		try(Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(getCustomer);
				PreparedStatement statement2 = connection.prepareStatement(getBankData);
				) {

			statement.setInt(1, customer.getCustomerId());
			statement.setString(2, customer.getPassword());

			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				statement2.setInt(1, result.getInt(7));
				authenticatedCustomer=new Customer(result.getString(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getDate(6).toLocalDate(), null);
				
			}
				


			ResultSet result2 = statement2.executeQuery();

			while(result2.next())
			{
				BankAccount bankAccount = new BankAccount(result2.getInt(1), result2.getInt(2), result2.getString(3));
				authenticatedCustomer.setBankAccount(bankAccount);
			}
			
			return authenticatedCustomer;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			return null;
		}


	}

	@Override
	public Customer updateProfile(Customer customer) {
		// TODO Auto-generated method stub
		Customer updatedCustomer=null;
		String updateCustomer = "UPDATE customerdata SET address=?,email=?  WHERE customerId=?";
		String getCustomerData = "select * from customerdata where customerId=?";
		String getBankData="select * from bankdata where accountId=?";
		try(Connection connection = DbUtil.getConnection();
				PreparedStatement statement2 = connection.prepareStatement(updateCustomer);
				PreparedStatement statement3 = connection.prepareStatement(getCustomerData);
				PreparedStatement statement4 = connection.prepareStatement(getBankData);) {
			
				
				
				statement2.setString(1, customer.getAddress());
				statement2.setString(2, customer.getEmail());
				statement2.setInt(3, customer.getCustomerId());
				
				if(statement2.executeUpdate()>-1)
				{
					statement3.setInt(1, customer.getCustomerId());

					ResultSet result = statement3.executeQuery();
					while(result.next())
					{
						statement4.setInt(1, result.getInt(7));

						updatedCustomer = new Customer(result.getString(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getDate(6).toLocalDate(), null);
						System.out.println(updatedCustomer);
					}
				}
				
				
				ResultSet result2 = statement4.executeQuery();

				while(result2.next())
				{
					BankAccount bankAccount = new BankAccount(result2.getInt(1), result2.getInt(2), result2.getString(3));
					System.out.println(bankAccount);
					updatedCustomer.setBankAccount(bankAccount);
				}
				
				return updatedCustomer;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
		String getCustomer = "select * from customerdata where customerId=?";
		String updatePassword = "UPDATE customerdata SET password=?  WHERE customerId=?";
		
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statementUpdatePassword = connection.prepareStatement(updatePassword);){
			if(customer.getPassword().equals(oldPassword))
			{

				statementUpdatePassword.setString(1, newPassword);
				statementUpdatePassword.setInt(2, customer.getCustomerId());
				if(statementUpdatePassword.executeUpdate()==1)return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
				
	}

}
