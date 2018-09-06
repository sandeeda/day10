package com.sandeep.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/convert")
public class CurrencyConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CurrencyConverterServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<style>\r\n" + 
				"table {\r\n" + 
				"    border-collapse: collapse;\r\n" + 
				"    width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"th, td {\r\n" + 
				"    text-align: center;\r\n" + 
				"    padding: 8px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"tr:nth-child(even){background-color: #f2f2f2}\r\n" + 
				"</style>");
		out.println("<table><th>Indian Rupees</th><th>USD equivalent</th>");
		for(int i=1;i<=50;i++)
		{
			out.println("<tr><td>"+" "+i+" </td>     <td>"+" "+i*45+"</td>");
		}
		out.println("</table>");
	}

}
