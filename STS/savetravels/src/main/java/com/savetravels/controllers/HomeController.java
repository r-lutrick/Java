package com.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.savetravels.models.ExpenseModel;
import com.savetravels.services.ExpenseService;

@Controller
public class HomeController {
	@Autowired
	private ExpenseService expenseService;

//	CREATE
	// form
//	@GetMapping("/expense/new")
//	public String createExpense() {
//		return "";
//	}

	// process
	@PostMapping("/expense/new")
	public String processExpense(@Valid @ModelAttribute("expense") ExpenseModel expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<ExpenseModel> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "Dashboard.jsp";
		}
		expenseService.addExpense(expense);
		return "redirect:/dashboard";
	}

//	RENDER
	// all
	@GetMapping("/dashboard")
	public String expensesDashboard(@ModelAttribute("expense") ExpenseModel expense, Model model) {
		List<ExpenseModel> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "Dashboard.jsp";
	}

	// one
	@GetMapping("/expense/{id}")
	public String expenseDetail(@PathVariable("id") Long id, Model model) {
		ExpenseModel expense = expenseService.oneExpense(id);
		model.addAttribute(expense);
		return ".jsp";
	}

//	UPDATE
	// form
	@GetMapping("/expense/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		ExpenseModel expense = expenseService.oneExpense(id);
		model.addAttribute("expense", expense);
		return "Update.jsp";
	}

	// process
	@PutMapping("/expense/edit/{id}")
	public String updateExpense(@Valid @ModelAttribute("expense") ExpenseModel expense, BindingResult result) {
		if (result.hasErrors()) {
			return "Update.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/dashboard";
	}

//	DELETE
	@DeleteMapping("/book/delete/{id}")
	public String removeExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/dashboard";
	}

}
