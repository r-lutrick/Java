package com.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.models.BookModel;
import com.authentication.repositories.BookRepository;

@Service
public class BookService {
//	Import Repository
	@Autowired
	private BookRepository bookRepo;
	
//	CREATE
	public BookModel addBook(BookModel newBook) {
		return bookRepo.save(newBook);
	}
	
//	RENDER
	// all
	public List<BookModel> allBooks(){
		return bookRepo.findAll();
	}
	// one
	public BookModel oneBook(Long id) {
		Optional<BookModel> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}

//	UPDATE
	public BookModel updateBook(BookModel foundBook) {
		return bookRepo.save(foundBook);
	}
	
//	DELETE
	public void remove(Long id) {
		bookRepo.deleteById(id);
	}
}
