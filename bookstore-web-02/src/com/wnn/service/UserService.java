package com.wnn.service;

import com.wnn.bean.User;
import com.wnn.dao.UserDao;

/**
 * 与用户相关的业务
 * @author Administrator
 *
 */
public class UserService {
	
	private UserDao userDao=new UserDao();
	//注册
	public int regist(User user){
		return userDao.insertUser(user);
	}
	//登录
	public User login(User user){
		return userDao.selectUserByUsernameAndPassword(user);
	}
}
