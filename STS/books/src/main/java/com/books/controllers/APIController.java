package com.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.models.BookModel;
import com.books.services.BookService;

@RestController
@RequestMapping("/api")
public class APIController {
	
	private final BookService bookService;

	public APIController(BookService bookService) {
		this.bookService = bookService;
	}
	
//	Get all
	@GetMapping("/books")
	public List<BookModel> getAllDonations() {
		return bookService.allBooks();
	}
	
	
//	Create
	@PostMapping("/newbook")
	public BookModel createBook(
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("numberOfPages") Integer numberOfPages
			) {
		BookModel newBook = new BookModel(title, description, language, numberOfPages);
		return bookService.addBook(newBook);
	}
	
	
}
