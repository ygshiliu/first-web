package com.wnn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodeServlet
 */
public class EncodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集（必须在第1次获取请求参数之前调用）
		request.setCharacterEncoding("utf-8");
		//获取请求参数 
		String username = request.getParameter("username");
		
		//输出一下
		System.out.println("post-用户名:"+username);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		//这种方式只对post请求起作用，而get请求是参数是放在请求报文的首部，由服务器解析
		//而服务器默认的字符集ISO-8859-1
		//需要修改server.xml文件中的 connector标签，内容如下
		//<Connector URIEncoding="utf-8" connectionTimeout="20000" port="8090" protocol="HTTP/1.1" redirectPort="8443"/>
		   
		//request.setCharacterEncoding("utf-8");
		//获取请求参数 
		String username = request.getParameter("username");
		//输出一下
		System.out.println("get-用户名:"+username);
		
		//指定服务器字符集
		//response.setCharacterEncoding("utf-8");
		//如果不设置浏览器端字符集，浏览器使用默认字符集，将保证不了结果一致
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//向浏览器发送一个片段
		PrintWriter out = response.getWriter();
		out.print("嘻嘻");
	}
	


}
