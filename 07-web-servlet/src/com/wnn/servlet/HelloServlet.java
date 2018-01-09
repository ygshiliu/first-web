package com.wnn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 1.创建servlet步骤：
 * ①.写一个类实现servlet接口
 * ②.需要在web.xml中进行配置
 * 
 * 	<!-- 配置servlet -->
 *	<servlet>
*		<!-- 别名，servlet容器对servlet的一切配置都是基于servletname进行的 -->
*		<servlet-name>HelloServlet</servlet-name>
*		<!-- 配置类的全类名 ，servlet容器是通过反射的方式来实例化servlet的-->
*		<servlet-class>com.wnn.servlet.HelloServlet</servlet-class>
*		<!-- 用来指定服务器启动时，就被初始化。这里的要设置一个大于等于0的值，值越小代表优先级越高 -->
		<load-on-startup>1</load-on-startup>
*	</servlet>
*	<!-- servlet映射信息 -->
*	<servlet-mapping>
*		<!-- servlet别名 -->
*		<servlet-name>HelloServlet</servlet-name>
*		<!-- 映射servlet请求路径 -->
*		<url-pattern>/HelloServlet</url-pattern>
*	</servlet-mapping>
*	
 * 说明：
 * 	web.xml修改过要重新启动服务器
 * 	urlpatter 中必须/开头
 * 	<!-- 用来指定服务器启动时，就被初始化。这里的要设置一个大于等于0的值，值越小代表优先级越高 -->
	<load-on-startup>1</load-on-startup>
	 
	映射路径配置方式：
	①精确匹配：url地址完全匹配
		http://localhost:8080/项目名/path/EServlet
	 	<url-pattern>/EServlet</url-pattern>
 *	②路径匹配：只要url匹配到path
 *		http://localhost:8080/项目名/app/
 *		<url-pattern>/app/*</url-pattern>
 *		匹配所有资源
 *		<url-pattern>/*</url-pattern>
 *	③后缀匹配：
 *		http://localhost:8080/项目名/app.do
 *		<url-pattern>*.do</url-pattern>
 *		错误的：
 *		<url-pattern>/*.do</url-pattern>
 *
 * 2.servlet生命周期
 * 	
 * 	人的生命周期指从出生到死的过程，要经过出生、活着、死亡三个阶段
 *  servlet的生命周期就是从被servlet容器创建到被Servlet容器销毁的过程
 *  
 *  生命周期方法：
 *  	构造器  ：
 *  		当servlet第1次处理请求时，才会被servlet容器创建，即构造器被调用，只调用1次，说明servlet是单例的
 *  		由于servlet是单例的，servlet容器在调用servlet时是以多线程的方式来处理的，所以在service方法中尽量不要出现共享资源
 *  
 *  	init(ServletConfig config)：
 *  		是在构造器被调用后，立刻被调用，也是调用1次
 *  		主要作用可以用来初始化设置
 *  
 *  	service(ServletRequest req, ServletResponse res)：
 *  		每次处理请求时都会调用此方法，会调用多次
 *  
 *  	destroy()：
 *  		当服务器停止或重新启动时会被调用，仅调用1次
 *  		主要用来释放资源，保存数据。
 * 	
 * 	现象：
 * 	第1次访问时，如下方法被调用
 * 	HelloServlet 构造器被调用，1次
	init 初始化方法被调用，1次
	service 方法被调用
	
	第2次访问后，只有service方法被调用，可以调用多次
	
	当服务器停止或重启时，destroy 方法被调用 ，1次
	
 */
public class HelloServlet implements Servlet{
	
	public HelloServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("HelloServlet 构造器被调用");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 初始化方法被调用");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * ServletRequest:浏览器发送给服务器的请求报文
	 * ServletResponse：服务器发送给浏览器的响应报文
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	System.out.println("request ...");
		System.out.println("===================");
		PrintWriter out = res.getWriter();
		
		out.write("response ... ");*/
		
		System.out.println("service 方法被调用");
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 销毁方法被调用");
	}

}
