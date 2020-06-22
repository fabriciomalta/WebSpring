package com.aula01web.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping(value = "/home")
	public String home() {
		return "home";
	}
	
	
	@GetMapping(value = {"/", "/login"})
	public String loginPage(@AuthenticationPrincipal User user) {
		
		if( user != null) {
			return "redirect:/home";
			//return "login";
		}
		return "login";
	}
}
