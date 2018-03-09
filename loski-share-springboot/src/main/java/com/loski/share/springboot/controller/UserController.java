package com.loski.share.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loski.share.springboot.entity.User;
import com.loski.share.springboot.service.UserService;
import com.loski.share.springboot.utils.Result;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/insert")
	public Result insert(@RequestBody User user){
		
		try {
			
			userService.insertUser(user);
			
			return Result.ok("添加成功");
			
		} catch (Exception e) {
			
			return Result.ok("添加失败");
			
		}
	}
}
