package com.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.authentication.models.BookModel;

public interface BookRepository extends CrudRepository<BookModel, Long> {
//	CRUD REPOSITORY -- save(), deleteById(..), no need to specify
	List<BookModel> findAll();
}