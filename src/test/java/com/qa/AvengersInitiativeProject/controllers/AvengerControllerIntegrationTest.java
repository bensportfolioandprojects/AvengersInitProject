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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.AvengersInitiativeProject.Domain.Avenger;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class AvengerControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void createTest() throws Exception {
		Avenger input = new Avenger("Steve", "Rodgers", "enhanced strength and speed");
		String inputAsJSON = mapper.writeValueAsString(input);
		
		Avenger output = new Avenger(2L, "Steve", "Rodgers", "enhanced strength and speed");
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(post("/avenger/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(outputAsJSON)); 
		
	}
	
	@Test
	public void getAllTest() throws Exception {
		Avenger avenger = new Avenger(1L, "Steve", "Rodgers", "enhanced strength and speed");
		List<Avenger> output = new ArrayList<>();
		output.add(avenger);
		
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/user/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		Avenger entry = new Avenger(1L, "Steve", "Rodgers", "enhanced strength and speed");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		mvc.perform(get("/avenger/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		Avenger entry = new Avenger("Steve", "Rodgers", "enhanced strength and speed");
		Avenger result = new Avenger(1L, "Steve", "Rodgers", "enhanced strength and speed");
		
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(put("/avenger/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/avenger/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNoContent());
	}
	

}
