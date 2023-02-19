package com.authentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.authentication.models.LoginUser;
import com.authentication.models.User;

@Controller
public class UserController {
	@GetMapping("/")
	public String loginRegForm(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "lognreg.jsp";
	}
}
