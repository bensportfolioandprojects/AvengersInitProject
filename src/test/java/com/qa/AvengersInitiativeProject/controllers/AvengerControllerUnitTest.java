package com.qa.AvengersInitiativeProject.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.AvengersInitiativeProject.Domain.Avenger;
import com.qa.AvengersInitiativeProject.services.AvengerService;


@WebMvcTest
public class AvengerControllerUnitTest {
	

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private AvengerService service;
	
	@Test
	void createTest() throws Exception {
		Avenger entry = new Avenger("Steve", "Rodgers", "super human strength and speed");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(service.create(entry)).thenReturn(entry);
		
		mvc.perform(post("/avenger/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void getAllTest() throws Exception {
		Avenger entry = new Avenger("Steve", "Rodgers", "super human strength and speed");
		List<Avenger> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		Mockito.when(this.service.getAll()).thenReturn(output);
		
		mvc.perform(get("/avenger/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		Avenger entry = new Avenger("Steve", "Rodgers", "super human strength and speed");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.getById(1L)).thenReturn(entry);
		
		mvc.perform(get("/avenger/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		Avenger entry = new Avenger("Steve", "Rodgers", "super human strength and speed");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.update(1L, entry)).thenReturn(entry);
		
		mvc.perform(put("/avenger/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		Mockito.when(service.delete(1L)).thenReturn(true);
	
		mvc.perform(delete("/avenger/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void deleteFailTest() throws Exception {
		Mockito.when(service.delete(1L)).thenReturn(false);
	
		mvc.perform(delete("/avenger/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}

}
