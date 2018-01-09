package com.wnn.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Bservlet implements Servlet {
	
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * ServletContext
		 * 【代表】代表整个web应用
		 * 【获取】通过servletConfig对象获取
		 * 【功能】
		 * 
		 */
		//获取servletContext对象
		ServletContext context = config.getServletContext();
		
		//获取web应用的初始化参数
		String value = context.getInitParameter("username");
		
		//获取指定目录在服务器上的部署的物理路径
		//物理路径：C:\Users\Administrator\Desktop\fourth\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\07-web-servlet\img
		//虚拟路径：http://localhost:8090/07-web-servlet/Bservlet
		//主要用来作上传和下传时使用
		//注意：指定的目录不一定存在，所以严谨做法是先进行判断后再获取
		String realPath = context.getRealPath("img");
		
		//作为一个域对象，在不同的web资源之间共享数据
		//javaweb中一共有4个域对象，servletContext就是其中之一
		
		//System.out.println(realPath);
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
