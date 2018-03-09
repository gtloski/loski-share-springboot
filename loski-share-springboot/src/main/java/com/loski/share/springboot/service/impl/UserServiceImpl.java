package com.loski.share.springboot.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loski.share.springboot.dao.UserDao;
import com.loski.share.springboot.entity.User;
import com.loski.share.springboot.service.UserService;
import tk.mybatis.mapper.entity.Example;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean login(String account, String password) {
		
		Example example = new Example(User.class);
		
		example.createCriteria().andEqualTo("account",account).andEqualTo("password",password);
		
		List<User> list = userDao.selectByExample(example);
		
		if(list!=null && list.size()>0){
			
			return true;
			
		}
		
		return false;
	}
	
	@Override
	public List<User> queryUserList(){
		
		List<User> user = userDao.selectAll();
		
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		
		String id = UUID.randomUUID().toString();
		
		user.setId(id);
		
		userDao.insert(user);
		
	}

}
