package com.wnn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wnn.bean.User;
import com.wnn.service.UserService;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
				
		//封装请求参数
		User user = new User(null, username, password, email);
		
		//调用业务层
		int count = us.regist(user);
		
		//根据返回结果返回响应
		if(count>0){
			//注册成功
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.html");
		}else{
			//注册失败
			request.getRequestDispatcher("/pages/user/regist_success.html").forward(request, response);
		}
	}

}
