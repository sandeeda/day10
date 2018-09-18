/*package com.sandeep.bank.dao.impl;

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



 */





package com.sandeep.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import com.sandeep.bank.dao.BankAccountDao;
import com.sandeep.bank.database.DataBase;
import com.sandeep.bank.model.BankAccount;
import com.sandeep.bank.util.DbUtil;

public class BankAccountDaoImpl implements BankAccountDao {
	String getBankData;
	public BankAccountDaoImpl() {
		// TODO Auto-generated constructor stub
		getBankData="select * from bankData";
	}

	@Override
	public double getBalance(long accountId) {
		// TODO Auto-generated method stub
		String getBalanceQuery="select * from bankdata where accountId=?";
		try(Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(getBalanceQuery);
				)
		{
			statement.setInt(1, (int) accountId);
			ResultSet result = statement.executeQuery();
			System.out.println("i am in get balance");
			while(result.next())
			{
				System.out.println(result.getInt(2));
				return result.getInt(2);
			}
		} 

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public boolean updateBalance(long accountId, double amount) {
		
		
		String updateBalanceQuery="update bankdata set balance=? where accountId=?";
		String getBalanceQuery="select balance from bankdata where accountid=?";
		System.out.println("i am here in update balance");

		try(Connection connection = DbUtil.getConnection();
				PreparedStatement updateBalanceQueryStatement = connection.prepareStatement(updateBalanceQuery);
				PreparedStatement getBalanceQueryStatement = connection.prepareStatement(getBalanceQuery);)
		{
			getBalanceQueryStatement.setInt(1, (int) accountId);
			ResultSet result = getBalanceQueryStatement.executeQuery();
			while(result.next())
			{
				System.out.println(result.getInt(1));
			updateBalanceQueryStatement.setInt(1, ((int) amount+result.getInt(1)));
			updateBalanceQueryStatement.setInt(2, (int) accountId);
			if(updateBalanceQueryStatement.executeUpdate()==1)
				return true;
			}
			
		} 

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;

	}

}

