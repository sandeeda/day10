package com.sandeep.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/readdetails")
public class CardDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CardDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long cardno=Long.parseLong(request.getParameter("cardno"));
		String expirymonth=request.getParameter("expirymonth");
		String expiryyear=request.getParameter("expiryyear");
		int cvv=Integer.parseInt(request.getParameter("cvv"));
		String nameoncard=request.getParameter("nameoncard");

		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<table border='1'>"
				+ "<tr>"
				+ "<th>card number</th>"
				+ "<th>expiry month</th>"
				+ "<th>expiry year</th>"
				
				+ "<th>cvv</th>"
				+ "<th>name on card</th>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>"
				+ cardno
				+"</td>"
				+ "<td>"
				+ expirymonth
				+"</td>"
				+ "<td>"
				+ expiryyear
				+"</td>"
				+ "<td>"
				+ cvv
				+"</td>"
				+ "<td>"
				+ nameoncard
				+"</td>"
				+"</tr>"
				+"</table>");
		
	}

}
