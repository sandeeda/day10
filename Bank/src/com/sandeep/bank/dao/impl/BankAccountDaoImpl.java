package com.sandeep.bank.dao.impl;

import java.util.HashSet;

import com.sandeep.bank.dao.BankAccountDao;
import com.sandeep.bank.database.DataBase;
import com.sandeep.bank.model.BankAccount;

public class BankAccountDaoImpl implements BankAccountDao {
	private HashSet<BankAccount> bankData;

	public BankAccountDaoImpl() {
		// TODO Auto-generated constructor stub
		bankData=DataBase.getAllBankData();
	}

	@Override
	public double getBalance(long accountId) {
		// TODO Auto-generated method stub
		for (BankAccount bankAccount : bankData) {
			if(bankAccount.getAccountId()==accountId)
			{
				return bankAccount.getBalance();
			}
		}
		return -1;
	}

	@Override
	public boolean updateBalance(long accountId, double amount) {
		// TODO Auto-generated method stub
		for (BankAccount bankAccount : bankData) {
			if(bankAccount.getAccountId()==accountId)
			{
				if(bankAccount.getBalance()+amount>=0) {
				bankAccount.setBalance(bankAccount.getBalance()+amount);
				System.out.println(bankAccount.getBalance());
				return true;
				}
			}
		}
		return false;
		
	}

}
