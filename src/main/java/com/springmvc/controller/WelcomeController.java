package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
}
