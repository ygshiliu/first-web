package com.wnn.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.wnn.bean.User;
import com.wnn.dao.UserDao;

public class UserDaoTest {
	
	private UserDao ud = new UserDao();
	@Test
	public void testInsertUser() {
		User user = new User(null, "xixi", "123123", "xixi@163.com");
		int count = ud.insertUser(user);
		System.out.println(count);
	}

	@Test
	public void testSelectUserByUsernameAndPassword() {
		User user = new User(null, "xixi", "123123", null);
		User one = ud.selectUserByUsernameAndPassword(user);
		System.out.println(one);
	}

}
