package com.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.books.models.BookModel;

public interface BookRepository extends CrudRepository<BookModel, Long> {
//	CRUD REPOSITORY -- save(), deleteById(..), no need to specify
	List<BookModel> findAll();
}