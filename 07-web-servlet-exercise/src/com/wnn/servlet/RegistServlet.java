package com.wnn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数 
		//通过getParameter获取的值都是String类型
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		System.out.println(username+"--"+password+"--"+gender+"--"+phone+"--"+email);
		
		//假定数据库中已经有一个admin帐户
		//根据用户名到数据库中获取用户信息，然后和用户输入的信息进行对比 
		//即：如果注册用户为admin,密码为123456 ，则用户存在返回error页面
		//如果不是，则为一个新用户，表示成功，返回success页面
		if("admin".equals(username) && "123456".equals(password)){
			//返回error
			response.sendRedirect("error.html");
		}else{
			//将用户信息保存到数据库中
			//返回success
			request.getRequestDispatcher("success.html").forward(request, response);
		}
		
	}

}
