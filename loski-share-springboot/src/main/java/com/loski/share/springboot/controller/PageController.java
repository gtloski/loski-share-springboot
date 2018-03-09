package com.loski.share.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loski-share")
public class PageController {

	@RequestMapping("/{module}/{url}")
	public String module(@PathVariable("module") String module, @PathVariable("url") String url){
		return "/" + module + "/" + url;
	}
}
