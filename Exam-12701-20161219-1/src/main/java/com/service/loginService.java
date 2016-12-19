package com.service;

import com.dao.impl.CustomerDAOImpl;

public class loginService {

	// 登录验证
	public String verifyUser(String userName) {
		String username = null;
		CustomerDAOImpl cdl = new CustomerDAOImpl();
		Boolean flag = true;
		flag = cdl.findUserByUserName(userName);
		// 判断是否有用户
		if (flag != false) {
/*			throw new RuntimeException(userName + " 不存在");
		} else {*/
			username = userName;
		}
		return username;
	}

}
