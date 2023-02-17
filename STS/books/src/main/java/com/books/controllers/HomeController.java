package com.books.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.books.models.BookModel;
import com.books.services.BookService;

@Controller
public class HomeController {
	@Autowired
	private BookService bookService;

//	Get all
	@GetMapping("/books")
	public String getAllDonations(Model model) {
		List<BookModel> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "Dashboard.jsp";
	}

//	Get one
	@GetMapping("/book/{id}")
	public String getOneBook(@PathVariable("id") Long id, Model model) {
		BookModel book = bookService.oneBook(id);
		model.addAttribute("book", book);
		return "Render.jsp";
	}
	
//	CreateForm
	@GetMapping("/book/new")
	public String bookForm(@ModelAttribute("book") BookModel book) {
		return "Create.jsp";
	}

//	CreateProcessing
	@PostMapping("/process")
	public String createBook(@Valid @ModelAttribute("book") BookModel book, BindingResult result) {
		bookService.addBook(book);
		return "redirect:/books";
	}

//	Update -- find one and create
	@PutMapping("/book/{id}")
	public BookModel editBook(@PathVariable("id") Long id, @RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("language") String language,
			@RequestParam("numberOfPages") Integer numberOfPages) {
		BookModel foundBook = bookService.oneBook(id);
		foundBook.setTitle(title);
		foundBook.setDescription(description);
		foundBook.setLanguage(language);
		foundBook.setNumberOfPages(numberOfPages);
		return bookService.updateBook(foundBook);
	}

//	Delete -- find one and remove
	@DeleteMapping("/book/{id}")
	public void removeBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}
