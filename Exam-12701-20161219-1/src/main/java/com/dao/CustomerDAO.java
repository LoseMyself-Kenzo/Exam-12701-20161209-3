package com.dao;

import com.entity.Customer;

public interface CustomerDAO {
	
	//查找顾客是否存在
	public Boolean findUserByUserName(String userName);
}
