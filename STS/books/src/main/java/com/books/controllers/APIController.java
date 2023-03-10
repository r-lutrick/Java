package com.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

//	Get one
	@GetMapping("/book/{id}")
	public BookModel getOneBook(@PathVariable("id") Long id) {
		return bookService.oneBook(id);
	}

//	Create
	@PostMapping("/book/new")
	public BookModel createBook(@RequestParam("title") String title, @RequestParam("description") String description,
			@RequestParam("language") String language, @RequestParam("numberOfPages") Integer numberOfPages) {
		BookModel newBook = new BookModel(title, description, language, numberOfPages);
		return bookService.addBook(newBook);
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
