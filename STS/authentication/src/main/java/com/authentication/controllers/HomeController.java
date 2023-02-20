package com.authentication.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import com.authentication.models.BookModel;
import com.authentication.services.BookService;
import com.authentication.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;

//	RENDER
	// all
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		// ASK ABOUT IF FURTHER VALIDATIONS i.e: IF USERID IS IN THE DB
		if (session.getAttribute("userId") == null) { // check if a user is logged in
			return "redirect:/";
		}
		List<BookModel> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "dashboard.jsp";
	}

	// one
	@GetMapping("/book/{id}")
	public String getOneBook(@PathVariable("id") Long id, Model model) {
		BookModel book = bookService.oneBook(id);
		model.addAttribute("book", book);
		return "render.jsp";
	}

//	CREATE
	// form
	@GetMapping("/create")
	public String bookForm(@ModelAttribute("book") BookModel book, HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) { // check if a user is logged in
			return "redirect:/";
		}
		return "create.jsp";
	}

	// process
	@PostMapping("/create")
	public String createBook(@Valid @ModelAttribute("book") BookModel book, BindingResult result) {
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			bookService.addBook(book);
			return "redirect:/dashboard";
		}
	}

//	UPDATE
	// form
	@GetMapping("/book/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
//		GET USER ID AND COMPARE
		if (session.getAttribute("userId") == null ) { // check if a user is logged in
			return "redirect:/";
		}
		BookModel book = bookService.oneBook(id);
		if (session.getAttribute("userId") != book.getUser()) { // check logged in user to book's creator
			return "redirect:/dashboard";
		}
		model.addAttribute("book", book);
		return "update.jsp";
	}

	// process
	@PutMapping("/book/{id}/edit")
	public String updateBook(@Valid @ModelAttribute("book") BookModel book, BindingResult result) {
		if (result.hasErrors()) {
			return "update.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/dashboard";
		}
	}

//	DELETE
	@DeleteMapping("/book/{id}/delete")
	public String removeBook(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") == null) { // check if a user is logged in
			return "redirect:/";
		}
		bookService.remove(id);
		return "redirect:/dashboard";
	}

}
