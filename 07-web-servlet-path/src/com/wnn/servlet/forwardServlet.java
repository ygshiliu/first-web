package com.wnn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FowordServlet
 */
public class forwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("====");
		
		//转发到1.html
		//http://localhost:8090/07-web-servlet-path/forwardServlet
		//request.getRequestDispatcher("/a/1.html").forward(request, response);
		
		//http://localhost:8090/a/1.html
		response.sendRedirect(request.getContextPath()+"/a/1.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
