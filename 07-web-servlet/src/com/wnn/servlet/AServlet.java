package com.wnn.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//servlet创建需要二步
//1是创建一个类实现servlet接口
//2是在web.xml中注册servlet
public class AServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		/**
		 * 	ServletConfig:
		 *  【代表】代表当前servlet在web.xml中的配置信息.
		 *  	 Servlet容器会将web.xml中对当前servlet的配置信息获取出来，封装到这个对象中
		 *  【获取】它是由servlet容器创建并作为参数传递给init方法，我们可以直接使用
		 *  【功能】
		 *  getServletName() ： 获取servlet别名
			
			getInitParameter(String)：
				<!-- 配置servlet的初始化参数 -->
				<init-param>
					<param-name>encoding</param-name>
					<param-value>utf-8</param-value>
				</init-param>
		 *  
		 *  getServletContext()：
		 */
		//获取servlet别名
		String name = config.getServletName();
		//获取servlet的初始化参数
		String encoding = config.getInitParameter("encoding");
		
		//获取servletContext,代表整个web应用
		//org.apache.catalina.core.ApplicationContextFacade@fd21d2f
		ServletContext context = config.getServletContext();
		System.out.println(context);
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
