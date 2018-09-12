package com.sandeep.bank.service.impl;

import java.util.HashSet;

import com.sandeep.bank.model.BankAccount;
import com.sandeep.bank.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {

	private HashSet<BankAccount> bankAccountDeatils = new HashSet<>();
	public BankAccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getBalance(long accountId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double withdraw(long accountId, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double deposit(long accountId, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
