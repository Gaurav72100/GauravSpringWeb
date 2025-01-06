package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
