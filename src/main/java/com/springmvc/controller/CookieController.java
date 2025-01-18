package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CookieController {
	
	@GetMapping("/set-cookie")
	@ResponseBody
	public String setCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("username" , "GauravKumar");
		cookie.setMaxAge(7 * 24 * 60 * 60);
		response.addCookie(cookie);
		return "Cookies has been set!";
		
		
	}
	
	@GetMapping("/get-cookie")
	@ResponseBody
	public String getCookie(@CookieValue(name="username", defaultValue="Guest") String username) {
		return "Hello"+username+"!";
		
	}

}
