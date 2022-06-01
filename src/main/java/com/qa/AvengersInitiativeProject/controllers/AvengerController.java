package com.qa.AvengersInitiativeProject.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.AvengersInitiativeProject.Domain.Avenger;
import com.qa.AvengersInitiativeProject.services.AvengerService;

@RestController
@CrossOrigin
@RequestMapping("/avenger")
public class AvengerController {
	
private AvengerService service;
	
	public AvengerController(AvengerService service) {
		this.service = service;
	}
	
	// Read -> Get Request -@GetMapping
	// Read ALL
	@GetMapping("/getAll")
	public ResponseEntity<List<Avenger>> getAll() {
		return new ResponseEntity<List<Avenger>>(this.service.getAll(), HttpStatus.OK);
	}
	
	// Read By ID
	@GetMapping("/getById/{id}")
	public ResponseEntity<Avenger> getById(@PathVariable long id) {
		return new ResponseEntity<Avenger>(service.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("/getByFirstName/{name}")
	public ResponseEntity<List<Avenger>> getByFirstName(@PathVariable String name) {
		return new ResponseEntity<List<Avenger>>(service.getByFirstName(name), HttpStatus.OK);
	}
	
	// Create -> Post Request - @PostMapping
	@PostMapping("/create")
	public ResponseEntity<Avenger> create(@RequestBody Avenger avenger) {
		return new ResponseEntity<Avenger>(service.create(avenger), HttpStatus.CREATED);
	}
	
	// Update -> Put/Patch Request - @PutMapping
	@PutMapping("/update/{id}")
	public ResponseEntity<Avenger> update(@PathVariable long id, @RequestBody Avenger avenger) {
		return new ResponseEntity<Avenger>(service.update(id, avenger), HttpStatus.ACCEPTED);
	}

//	 Delete -> Delete Request - @DeleteMapping
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

