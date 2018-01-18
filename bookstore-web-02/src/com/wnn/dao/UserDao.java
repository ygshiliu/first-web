package com.wnn.dao;

import com.wnn.bean.User;
/**
 * 用来与数据库操作用户相关的操作
 * @author Administrator
 *
 */
public class UserDao extends BaseDao<User> {
	
	//注册
	public int insertUser(User user){
		//写sql语句
		String sql = "insert into bs_user (username,password,email) values(?,?,?)";
		int count = update(sql, user.getUsername(),user.getPassword(),user.getEmail());
		return count;
	}
	//登录
	public User selectUserByUsernameAndPassword(User user){
		//写sql语句
		String sql = "select id,username,password,email from bs_user where username=? and password = ?";
		User one = queryOne(sql, user.getUsername(),user.getPassword());
		return one;
	}
}
