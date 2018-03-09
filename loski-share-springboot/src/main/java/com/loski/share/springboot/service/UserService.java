package com.loski.share.springboot.service;

import java.util.List;

import com.loski.share.springboot.entity.User;

public interface UserService {

	boolean login(String account, String password);
	
	List<User> queryUserList();
	
	void insertUser(User user) throws Exception;
}
