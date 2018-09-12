package com.sandeep.bank.database;

import java.util.HashSet;

import com.sandeep.bank.model.BankAccount;

public class DataBase {

	public DataBase() {
		// TODO Auto-generated constructor stub
		
	}
	public HashSet<BankAccount> getAllBankData()
	{
		
		HashSet<BankAccount> bankData = new HashSet<>();
		bankData.add(new BankAccount(20239027783L, 37649, "SAVINGS"));
		bankData.add(new BankAccount(20239027784L, 47749, "CURRENT"));
		bankData.add(new BankAccount(20239027785L, 57849, "SAVINGS"));
		bankData.add(new BankAccount(20239027786L, 67949, "CURRENT"));
		bankData.add(new BankAccount(20239027787L, 77659, "SAVINGS"));
		bankData.add(new BankAccount(20239027788L, 87669, "CURRENT"));
		bankData.add(new BankAccount(20239027789L, 97679, "SAVINGS"));
		return bankData;
		
	}

}
