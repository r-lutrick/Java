package com.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "Index.jsp";
	}

	@GetMapping("/counter")
	public String counter(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			// Type casting Integer is needed here since getAttribute returns an object 
			session.setAttribute("count", (Integer)session.getAttribute("count") + 1);
		}
		return "/sessions/Counter.jsp";
	}
	
	@GetMapping("/double")
	public String doubleCounter(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			// Type casting Integer is needed here since getAttribute returns an object 
			session.setAttribute("count", (Integer)session.getAttribute("count") + 2);
		}
		return "/sessions/Counter.jsp";
	}
	
	@GetMapping("/reset")
	public String resetCounter(HttpSession session) {
		if (session.getAttribute("count") != null) {
			session.setAttribute("count", 0);
		}
		return "/sessions/Counter.jsp";
	}

}
