package com.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savetravels.models.ExpenseModel;
import com.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepo;
	
//	CREATE
	public ExpenseModel addExpense(ExpenseModel newExpense) {
		return expenseRepo.save(newExpense);
	}
	
//	RENDER
	// all
	public List<ExpenseModel> allExpenses() {
		return expenseRepo.findAll();
	}
	
	// one
	public ExpenseModel oneExpense(Long id) {
		Optional<ExpenseModel> opExpense = expenseRepo.findById(id);
		if (opExpense.isPresent()) {
			return opExpense.get();
		}
		return null;
	}
	
//	UPDATE
	public ExpenseModel updateExpense(ExpenseModel foundExpense) {
		return expenseRepo.save(foundExpense);
	}
	
//	DELETE
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
}
