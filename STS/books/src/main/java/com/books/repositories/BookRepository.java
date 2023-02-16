package com.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.books.models.BookModel;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Long> {
//	CRUD REPOSITORY -- save(), deleteById(..), no need to specify
	List<BookModel> findAll();

}
