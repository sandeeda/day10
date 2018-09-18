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

import com.sandeep.bank.exceptions.PayeeAccountNotFoundException;
import com.sandeep.bank.model.Customer;
import com.sandeep.bank.service.BankAccountService;
import com.sandeep.bank.service.CustomerService;
import com.sandeep.bank.service.impl.BankAccountServiceImpl;


@WebServlet("/fundTransfer")
public class FundTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext context; 
    private ServletContext serviceContext; 
    private BankAccountService bankAccountService;
    private CustomerService customerService;
    
    
    public FundTransferController() {
        super();
    }

	
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	bankAccountService = new BankAccountServiceImpl();
    	context = config.getServletContext();
    	serviceContext = config.getServletContext();
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long payeeAccountNumber = Long.parseLong(request.getParameter("payeeAccountNumber"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		Customer custTemp;
		customerService = (CustomerService) serviceContext.getAttribute("customerService");
		HttpSession session = request.getSession();
		custTemp = (Customer) session.getAttribute("customer");
		
		System.out.println(payeeAccountNumber);
		RequestDispatcher dispatcher;
		try {
			if(bankAccountService.fundTransfer(custTemp.getBankAccount().getAccountId(), payeeAccountNumber, amount))
			{
				
				
				Customer customerMapper = (Customer) session.getAttribute("customer");

				Customer customerEditted = new Customer(null, customerMapper.getCustomerId(), null, null, null, null, null);

				customerEditted.setAddress(custTemp.getAddress());
				customerEditted.setEmail(custTemp.getEmail());
				

				session.setAttribute("customer", customerService.updateProfile(customerEditted));
				dispatcher = request.getRequestDispatcher("transferSuccess.jsp");
				

			}
			else
			{
				dispatcher = request.getRequestDispatcher("transferFail.jsp");
			}
		} catch (PayeeAccountNotFoundException e) {
			// TODO Auto-generated catch block
			request.setAttribute("fundTransferFail", e.getMessage());
			dispatcher = request.getRequestDispatcher("transferFail.jsp");

		}
		
		
		
		
		dispatcher.include(request, response);
	}
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		long payeeAccountNumber = Long.parseLong(request.getParameter("payeeAccountNumber"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		Customer custTemp;
		
		HttpSession session = request.getSession();
		custTemp = (Customer) session.getAttribute("customer");
		
		System.out.println(payeeAccountNumber);
		RequestDispatcher dispatcher;
		bankAccountService.deposit(payeeAccountNumber, amount);
		request.setAttribute("success", true);
		response.sendRedirect("http://10.246.92.175:8070/IdbiBankApp/success.jsp?success=true");
	
		
	}
*/

}
