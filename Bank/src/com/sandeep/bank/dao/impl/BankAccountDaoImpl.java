package com.sandeep.bank.dao.impl;

import java.util.HashSet;

import com.sandeep.bank.dao.BankAccountDao;
import com.sandeep.bank.database.DataBase;
import com.sandeep.bank.model.BankAccount;

public class BankAccountDaoImpl implements BankAccountDao {
	private DataBase dataBase;
	public BankAccountDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getBalance(long accountId) {
		// TODO Auto-generated method stub
		HashSet<BankAccount> bankData = new HashSet<>();
		bankData = dataBase.getAllBankData();
		return 100;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		// TODO Auto-generated method stub
		return false;
	}

}
