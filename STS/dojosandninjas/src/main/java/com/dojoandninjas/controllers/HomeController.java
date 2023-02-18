package com.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoandninjas.models.Dojo;
import com.dojoandninjas.models.Ninja;
import com.dojoandninjas.services.DojoService;
import com.dojoandninjas.services.NinjaService;

@Controller
public class HomeController {
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	
//	CREATE DOJO
	// Display
	@GetMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "NewDojo.jsp";
	}
	// Process
	@PostMapping("/dojo/new")
	public String processNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "NewDojo.jsp";
		}
		dojoService.addDojo(dojo);
		return "redirect:/dojo/new";
	}
	
//	CREATE NINJA
	// Display
	@GetMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojo = dojoService.allDojos();
		model.addAttribute("dojos", dojo);
		return "NewNinja.jsp";
	}
	// Process
	@PostMapping("/ninja/new")
	public String processNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "NewNinja.jsp";
		}
		ninjaService.addNinja(ninja);
		return "redirect:/ninja/new";
	}
	
//	SHOW DOJO
	// Display
	@GetMapping("/dojo/{id}")
	public String viewDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.oneDojo(id);
		model.addAttribute("dojo", dojo);
		return "DojoView.jsp";
	}
}
