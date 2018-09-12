package com.sandeep.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String accountId = request.getParameter("accountId");
		String password = request.getParameter("password");
		
		
		
		PrintWriter out = response.getWriter();
		request.setAttribute("accountId", accountId);
		request.setAttribute("password", password);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginservice.do");
		dispatcher.include(request, response);
		
	}

}
