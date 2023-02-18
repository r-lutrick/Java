package com.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoandninjas.models.Ninja;
import com.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
//	CREATE
	public Ninja addNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
//	RENDER
	// all
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
}
