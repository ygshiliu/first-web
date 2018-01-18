package com.wnn.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wnn.utils.JDBCUtil;

public class BaseDao<T> {
	//QueryRunner使用update方法做增删改，使用query做查询
	private QueryRunner qr = new QueryRunner();
	private Class<T> type;
	
	public BaseDao() {
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType param = (ParameterizedType)genericSuperclass;
		this.type = (Class<T>) param.getActualTypeArguments()[0];
		System.out.println(type);
	}
	//增册改
	public int update(String sql,Object ... params ){
		Connection conn = JDBCUtil.getConnection();
		int count = 0;
		try {
			count = qr.update(conn, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.CloseConnection(conn);
		}
		return count;
	}
	
	//查询一条数据
	public T queryOne(String sql,Object ... params ){
		Connection conn = JDBCUtil.getConnection();
		T t = null;
		try {
			t = qr.query(conn, sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.CloseConnection(conn);
		}
		return t;
	}
	//查询所有数据
	public List<T> queryMore(String sql,Object ... params ){
		Connection conn = JDBCUtil.getConnection();
		List<T> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.CloseConnection(conn);
		}
		return list;
	}
}
