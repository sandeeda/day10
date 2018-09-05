package com.sandeep.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HelloWorldServlet() {
        super();
        System.out.println("constructor is called");
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("init method is called");
    }
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("do get called");
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	out.println("<h1>hello world</h1>");
    	out.close();
    	
    }
    
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	System.out.println("destroy method is called");
    }
    
	
	

}
