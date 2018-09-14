package com.sandeep.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sandeep.bank.model.Customer;
import com.sandeep.bank.service.BankAccountService;
import com.sandeep.bank.service.impl.BankAccountServiceImpl;


@WebServlet("/fundTransfer")
public class FundTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext context; 
    private BankAccountService bankAccountService;
    
    
    public FundTransferController() {
        super();
    }

	
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	bankAccountService = new BankAccountServiceImpl();
    	context = config.getServletContext();
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long payeeAccountNumber = Long.parseLong(request.getParameter("payeeAccountNumber"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		Customer custTemp;
		
		HttpSession session = request.getSession();
		custTemp = (Customer) session.getAttribute("customer");
		
		System.out.println(payeeAccountNumber);
		RequestDispatcher dispatcher;
		if(bankAccountService.fundTransfer(custTemp.getBankAccount().getAccountId(), payeeAccountNumber, amount))
		{
			dispatcher = request.getRequestDispatcher("transferSuccess.jsp");

		}
		else
		{
			dispatcher = request.getRequestDispatcher("transferFail.jsp");
		}
		
		dispatcher.include(request, response);
	}

}
