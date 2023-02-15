package com.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "Index.jsp";
	}

	@GetMapping("/input")
	public String inputForm() {
		return "/omikujiForm/inputForm.jsp";
	}

	@PostMapping("/process")
	public String processForm(@RequestParam("luckyNumber") String luckyNumber, @RequestParam("city") String city,
			@RequestParam("person") String person, @RequestParam("hobby") String hobby,
			@RequestParam("livingThing") String livingThing, @RequestParam("comment") String comment, HttpSession session) {
		session.setAttribute("luckyNumber", luckyNumber);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("comment", comment);
		return "redirect:/display";
	}

	@GetMapping("/display")
	public String displayForm() {
		return "/omikujiForm/displayForm.jsp";
	}
}
