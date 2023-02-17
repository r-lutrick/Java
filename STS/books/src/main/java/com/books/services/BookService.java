package com.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.models.BookModel;
import com.books.repositories.BookRepository;

@Service // THIS IS WHERE CRUD HAPPENS
public class BookService {
//	1st option
//	private final BookRepository bookRepo;
//
//	public BookService(BookRepository bookRepo) {
//		this.bookRepo = bookRepo;
//	}

//	2nd option
	@Autowired
	private BookRepository bookRepo;

//	find all books
	public List<BookModel> allBooks() {
		return bookRepo.findAll();
	}

//	find one book
	public BookModel oneBook(Long id) {
		Optional<BookModel> optionalBook = bookRepo.findById(id); // optional data type will tell you if something
																	// exists or not
		if (optionalBook.isPresent()) { // checks if its in the DB
			return optionalBook.get();
		} else {
			return null;
		}
	}

//	create book
	public BookModel addBook(BookModel newBook) {
		return bookRepo.save(newBook);
	}

//	update book
	public BookModel updateBook(BookModel foundBook) {
		return bookRepo.save(foundBook);
	}

//	delete book
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
