package com.qa.AvengersInitiativeProject.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.AvengersInitiativeProject.Domain.Avenger;
import com.qa.AvengersInitiativeProject.repo.AvengerRepo;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
public class AvengerServiceTest {
	
	@Autowired
	private AvengerService service;

	@MockBean
	private AvengerRepo repo;

	// Create Test
	@Test
	public void createTest() {
		Avenger input = new Avenger("Steve", "Rodgers", "super human strength and speed");
		Avenger output = new Avenger(1L, "Steve", "Rodgers", "super human strength and speed");
		
		Mockito.when(repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, service.create(input));
		
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(input);
	}

	// ReadAll Test
	@Test
	public void getAllTest() {
		// Creating any expected output and inputs if necessary
		List<Avenger> output = new ArrayList<>();
		output.add(new Avenger(1L, "Steve", "Rodgers", "super human strength and speed"));
		
		// Mocking the dependency (repo)
		Mockito.when(repo.findAll()).thenReturn(output);
		
		// Asserting the actual test method's output
		assertEquals(output, service.getAll());
		
		// Verifying the number of times a mock method ran - Not Required
		Mockito.verify(repo, Mockito.times(1)).findAll(); 
	}

	// Read By ID Test
	@Test
	public void getByIdTest() {
		// Creating any expected output and inputs if necessary
		Avenger output = new Avenger(1L, "Steve", "Rodgers", "super human strength and speed");
		Optional<Avenger> optionalOutput = Optional.of(output);
		
		// Mocking the dependency (repo)
		Mockito.when(repo.findById(1L)).thenReturn(optionalOutput);
		
		// Asserting the actual test method's output
		assertEquals(output, service.getById(1L));
		
		// Verifying the number of times a mock method ran - Not Required
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
	}
	
	// Read By FirstName Test
		@Test
		public void getByFirstNameTest() {
			// Creating any expected output and inputs if necessary
			Avenger output = new Avenger(1L, "Steve", "Rodgers", "super human strength and speed");
			output.add(new Avenger(1L, "Steve", "Rodgers", "super human strength and speed"));
			// Mocking the dependency (repo)
			Mockito.when(repo.findByFirstName(Steve)).thenReturn(output);
			// Asserting the actual test method's output
			assertEquals(output, service.getByFirstName());
			// Verifying the number of times a mock method ran - Not Required
			Mockito.verify(repo, Mockito.times(1)).findByFirstName();
		}

	// Update Test
	@Test
	public void updateTest() {
		// Creating any expected output and inputs if necessary
		Avenger input = new Avenger("Steve", "Rodgers", "super human strength and speed");
		Optional<Avenger> existing = Optional.of(new Avenger(1L, "Tony", "Stark", "Superior intelligence"));
		Avenger output = new Avenger(1L, "Steve", "Rodgers", "super human strength and speed");
		
		// Mocking the dependency (repo)
		Mockito.when(repo.findById(1L)).thenReturn(existing);
		Mockito.when(repo.saveAndFlush(output)).thenReturn(output);
		
		// Asserting the actual test method's output
		assertEquals(output, service.update(1L, input));
		
		// Verifying the number of times a mock method ran - Not Required
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(output);
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
	}

	
	
	// Delete Test
	@Test
	public void deleteTest() {
		// Creating any expected output and inputs if necessary
		final long Id = 1L;
		// Mocking the dependency (repo)
		Mockito.when(repo.deleteById(Id)).thenReturn(true);
		// Asserting the actual test method's output
		assertEquals(true, service.delete(Id));
		// Verifying the number of times a mock method ran - Not Required
//		Mockito.verify(repo, Mockito.times(1)).findAll();

}

	}
