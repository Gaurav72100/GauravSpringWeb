package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WelcomeController {

	
	@RequestMapping("/")
	public  String meet() {
		System.out.println("WelcomeController called");
	    System.out.println("/ Called.........");
		return "welcome";
	}
	
	
	
	
}
