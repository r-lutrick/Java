package com.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.books.models.BookModel;
import com.books.repositories.BookRepository;


@Service
public class BookService {
//	1st option
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
//	2nd option
	
	
//	findAll: get all books
	public List<BookModel> allBooks(){
		return bookRepo.findAll();
	}
	
//	create books
	public BookModel addBook(BookModel newBook) {
		return bookRepo.save(newBook);
	}
}
