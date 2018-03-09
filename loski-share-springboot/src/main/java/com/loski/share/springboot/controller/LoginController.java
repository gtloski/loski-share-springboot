package com.loski.share.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loski.share.springboot.service.UserService;

@Controller
@RequestMapping("/loski-share")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String insert(@RequestParam String account, @RequestParam String password, Model model){
		
			boolean flag = userService.login(account, password);
			
			if(flag){
				
				model.addAttribute("msg", "登陆成功");
				
			}else{
				
				model.addAttribute("msg", "登陆失败");
			
			}
			
            return "/common/login";
            
	}
}
