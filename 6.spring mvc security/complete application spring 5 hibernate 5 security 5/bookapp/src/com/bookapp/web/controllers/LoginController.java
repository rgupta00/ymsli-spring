package com.bookapp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@GetMapping("/")	
	public String showPage(){
		return "home";
	}
	
	@GetMapping(value="/admin")	
	public String showAdmin(){
		return "home_admin";
	}
	

	@GetMapping(value="/access_denied")	
	public String showAccessDeniedPage(){
		return "access_denied";
	}
	
	
	@GetMapping(value="/mgr")	
	public String showMgr(){
		return "home_mgr";
	}
	
	
	@GetMapping("/showLoginPage")	
	public String showLoginPage(){
		return "login_page";
	}
}
