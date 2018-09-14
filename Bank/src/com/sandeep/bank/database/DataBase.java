package com.sandeep.bank.database;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;

import com.sandeep.bank.model.BankAccount;
import com.sandeep.bank.model.Customer;

public class DataBase {

	public DataBase() {
		// TODO Auto-generated constructor stub
		
	}
	static HashSet<BankAccount> bankData = new HashSet<>();
	static HashSet<Customer> customerData = new HashSet<>();

	static
	{
		BankAccount b1 = new BankAccount(20239027783L, 100, "SAVINGS");
		BankAccount b2 = new BankAccount(20239027784L, 100, "CURRENT");
		BankAccount b3 = new BankAccount(20239027785L, 100, "SAVINGS");
		BankAccount b4 = new BankAccount(20239027786L, 100, "CURRENT");
		BankAccount b5 = new BankAccount(20239027787L, 100, "SAVINGS");
		BankAccount b6 = new BankAccount(20239027788L, 100, "CURRENT");
		BankAccount b7 = new BankAccount(20239027789L, 100, "SAVINGS");
	
		bankData.add(b1);
		bankData.add(b2);
		bankData.add(b3);
		bankData.add(b4);
		bankData.add(b5);
		bankData.add(b6);
		bankData.add(b7);
		customerData.add(new Customer("Sandeep Das", 1234, "cijyjyx3", "sdsts28@gmail.com", "ranchi", LocalDate.parse("1996-06-25"),b1));
		customerData.add(new Customer("K Malyka", 4567, "cijyjyx4", "kmalyka@gmail.com", "hyderabad", LocalDate.parse("1996-08-18"),b2));
		customerData.add(new Customer("Sudarshan", 9874, "cijyjyx5", "sshanbhag@gmail.com", "bengaluru", LocalDate.parse("1996-06-15"),b3));
		customerData.add(new Customer("Manjulavani", 9512, "cijyjyx6", "manju28@gmail.com", "goa", LocalDate.parse("1996-07-25"),b4));
		customerData.add(new Customer("logi", 9999, "cijyjyx7", "logi@gmail.com", "delhi", LocalDate.parse("1996-08-25"),b5));
		customerData.add(new Customer("poudel", 8888, "cijyjyx8", "poudel28@gmail.com", "puna", LocalDate.parse("1996-09-25"),b6));
		customerData.add(new Customer("switty", 4444, "cijyjyx9", "switty@gmail.com", "coorg", LocalDate.parse("1996-10-25"),b7));
	}
	public static HashSet<BankAccount> getAllBankData()
	{
		
		
		return bankData;
		
	}
	public static HashSet<Customer> getAllCustomerData()
	{
		
		return customerData;
	}
	public static void setAllBankData(HashSet<BankAccount> bankDataUpadated) {
		// TODO Auto-generated method stub
		bankData=bankDataUpadated;
	}
	
	public static void setAllCustomerData(HashSet<Customer> customerDataUpadated) {
		// TODO Auto-generated method stub
		customerData=customerDataUpadated;
	}

}
