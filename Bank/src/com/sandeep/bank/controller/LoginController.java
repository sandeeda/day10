package com.sandeep.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sandeep.bank.model.Customer;
import com.sandeep.bank.service.CustomerService;
import com.sandeep.bank.service.impl.CustomerServiceImpl;


@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerService customerService;
	private Customer customer;
	private ServletContext context;

    public LoginController() {
        super();
        customerService = new CustomerServiceImpl();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	context=config.getServletContext();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String customerId = request.getParameter("customerId");
		String password = request.getParameter("password");
		
		
		
		/*request.setAttribute("accountId", customerId);
		request.setAttribute("password", password);*/
		
		
		
		customer=new Customer(null, Integer.parseInt(customerId), password, null, null, null, null);
		HttpSession session=request.getSession();
		session.setAttribute("customer",customerService.authenticate(customer));
		context.setAttribute("customerService", customerService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("displayDetails.jsp");
		dispatcher.forward(request, response);
		
	}

}
