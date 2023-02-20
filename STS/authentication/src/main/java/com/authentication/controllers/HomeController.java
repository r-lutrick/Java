package com.authentication.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
//		ASK ABOUT IF FURTHER VALIDATIONS i.e: IF USERID IS IN THE DB
		if (session.getAttribute("userId") == null) { // check if a user is logged in
			return "redirect:/";
		}
		return "dashboard.jsp";
	}

}
