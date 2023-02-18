package com.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoandninjas.models.Dojo;
import com.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
//	CREATE
	public Dojo addDojo(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	
//	RENDER
	// one
	public Dojo oneDojo(Long id) {
		Optional<Dojo> opDojo = dojoRepo.findById(id);
		if(opDojo.isPresent()) {
			return opDojo.get();
		}
		return null;
	}
	// all
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
}
