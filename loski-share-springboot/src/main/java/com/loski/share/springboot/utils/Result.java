package com.loski.share.springboot.utils;

import java.util.HashMap;

public class Result extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3210225238330839638L;

	public static Result ok(String msg) {
		
		Result r = new Result();
		
		r.put("msg", msg);
		
		return r;
	}
	
	public static Result error(String msg) {
		
		Result r = new Result();
		
		r.put("msg", msg);
		
		return r;
	}
}
