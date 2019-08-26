package com.spring.springrestcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthenticationController {
	
	@GetMapping("/loginpage")
	public String loginPage() {
		return "loginpage";
	}

}
