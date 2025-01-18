package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	
	@RequestMapping("/")
	public  String meet() {
		System.out.println("WelcomeController called");
	
		return "welcome";
	}
	
	@RequestMapping("/hi")
	public  String gmeet() {
		System.out.println("WelcomeController gmeet");
	
		return "index";
	}
	@RequestMapping("/hello")
	public String display(@RequestParam(name="user", defaultValue="..........") String username) {
		System.out.println("UserName is"+username);
		return "index";
	}
	
	@RequestMapping("/get/{id}")
	@ResponseBody
	public String pathVar(@PathVariable(name="id", required=false)int userId) {
		System.out.println("Value of path Variable is:" + userId);
		return "<h2>This is response not a view Spring mvc provides ResponseBody annotation that simplifies you always not return view<h2>";
	}
	
}
