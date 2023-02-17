package com.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.savetravels.models.ExpenseModel;

public interface ExpenseRepository extends CrudRepository<ExpenseModel, Long> {
	List<ExpenseModel> findAll();
}