package com.qa.AvengersInitiativeProject.services;

import org.hibernate.mapping.List;

import com.qa.AvengersInitiativeProject.Domain.Avenger;
import com.qa.AvengersInitiativeProject.repo.AvengerRepo;
import org.springframework.stereotype.Service;

public class AvengerService {
	
	private AvengerRepo repo;
	
	public AvengerService(AvengerRepo repo) {
		this.repo = repo;
	}
	
	// Create
	public Avenger create(Avenger avenger) {
		return repo.saveAndFlush(avenger);
	}
	
	// ReadAll
	public List<Avenger> getAll() {
		return repo.findAll();
	}
	
	// Read By ID
	public Avenger getById(long id) {
		return repo.findById(id).get();
//		return repo.findById(id).orElseThrow(UserNotFoundException::new);
//		return repo.findById(id).orElseThrow(() -> new AvengerNotFoundExceptionWithID(id));
	}
	
	// Read By FirstName
	public List<Avenger> getByFirstName(String name) {
		return repo.findByFirstName(name);
	}
	
	// Update
	public Avenger update(long id, Avenger avenger) {
		// First, get the existing entry
		Avenger existing = repo.findById(id).get();
		
		// Then, updated the existing entry using the new object
		existing.setFirstName(avenger.getFirstName());
		existing.setLastName(avenger.getLastName());
		existing.setPower(avenger.getPower());
		
		return repo.saveAndFlush(existing);
	}

	// Delete
	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}
