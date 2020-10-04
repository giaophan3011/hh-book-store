package com.haagahelia.serverprogramming.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	@GetMapping("/login")
	public String getLoginPage (Model model) {			
		return "login";
	}	
	
}
