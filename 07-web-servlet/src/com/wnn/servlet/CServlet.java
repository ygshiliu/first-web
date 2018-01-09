package com.wnn.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class CServlet implements Servlet,ServletConfig{
	
	private ServletConfig config;
	
	//注意：此方法不能被重写，不然会出现java.lang.NullPointerException
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
		init();
	}
	
	public void init() throws ServletException {}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	public abstract void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException ;

	@Override
	public String getServletInfo() {
		return "";
	}

	@Override
	public void destroy() {	}

	@Override
	public String getServletName() {
		// TODO Auto-generated method stub
		return config.getServletName();
	}

	@Override
	public ServletContext getServletContext() {
		System.out.println(config);
		return config.getServletContext();
	}

	@Override
	public String getInitParameter(String name) {
		// TODO Auto-generated method stub
		return config.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		// TODO Auto-generated method stub
		return config.getInitParameterNames();
	}

}
