package com.wnn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EServlet
 */
public class EServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 响应报文格式：
		 * 	响应首部
		 * 	空行
		 *  响应体
		 * 
		 * HttpServletResponse:
		 * 【代表】代表服务器发送给浏览器的响应报文
		 * 【获取】由服务器创建，并作为参数传递给doGet与doPost方法，我们可以直接使用
		 * 【功能】
		 * 
		 */
		
		//1.设置响应头
		//Content-Type: text/html
		//response.setHeader("Content-Type", "text/html；charset=utf-8");
		
		//设置响应体内容的类型
		//response.setContentType("text/html;charset=utf-8");

		
		//2.可以向浏览器发送一个网页或一段网页片段
		//getOutputStream()获取一个字节流
		//getWriter()获取一个字符流
		// PrintWriter writer = response.getWriter();
		//writer.write("Hello Client");
		
		/**
		 * 3.可以发起网页的重定向
		 * 
		 * 什么是重定向？
		 * 就是服务器收到请求后，会向浏览器返回一个响应报文。浏览器收到后会根据这个响应报文重新发送请求
		 * 
		 * 响应报文的状态码为302，还有一个头location。浏览器收到后会重新发送一个请求到location指向的地址
		 * HTTP/1.1 302 Found
		 * Location: AServlet
		 * 
		 * 重定向的特点：
		 * 	浏览器地址栏有变化
		 *  浏览器发送了2次请求
		 *  重定向发生在浏览器端
		 */
		response.sendRedirect("AServlet");
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 请求报文的格式：
		 * Get请求报文：
		 * 	 请求首部（请求首行和请求头）
		 * 
		 * Post请求报文：
		 *  请求首部
		 *  空行
		 *  请求体
		 * 
		 * HttpServletRequest:
		 * 【代表】代表浏览器发送给服务器的请求报文
		 * 【获取】由服务器创建并作为参数传递给doPost或doGet方法
		 * 【功能】
		 * 
		 */
		
		//1.获取指定的请求参数 
		//String username = request.getParameter("username");
		
		//2.获取session(域对象）
		HttpSession session = request.getSession();
		//3.获取servletcontext对象(域对象）
		ServletContext servletContext = request.getServletContext();
		//4.它本身也是一个域对象，可以在不同的web资源中共享数据
		
		/**
		 * 5.可以发起请求的转发
		 * 
		 * 什么是请求的转发？
		 * 就是当前servlet收到请求后，并不直接返回响应，而是将请求交给了其它资源处理请求
		 * 
		 * 转发的特点：
		 * 浏览器发送了1次请求
		 * 地址栏没有变化 
		 * 转发发生在服务器端
		 */
		//获取派发器
		RequestDispatcher dispatcher = request.getRequestDispatcher("/frist.html");
		//转发
		dispatcher.forward(request, response);
	}

}
