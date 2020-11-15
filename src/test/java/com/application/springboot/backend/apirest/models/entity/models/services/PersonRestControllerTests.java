package com.application.springboot.backend.apirest.models.entity.models.services;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.application.springboot.backend.apirest.controllers.PersonRestController;
import com.application.springboot.backend.apirest.models.entity.Person;
import com.application.springboot.backend.apirest.models.entity.models.dao.IPersonDao;
import com.application.springboot.backend.apirest.models.entity.models.services.IPersonService;
import com.application.springboot.backend.apirest.models.entity.models.services.PersonServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonRestControllerTests{
	
	
	
	@Autowired	
	private MockMvc mockMvc;
		
	
	@Autowired
	private PersonServiceImpl service;
		
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private IPersonDao repository;
	
	

	@Test
	public void testListPersons() throws Exception {
		
		List<Person> listPerson = new ArrayList<>();
		listPerson.add(new Person(2, "andres", new Date(), 3, 4));
		listPerson.add(new Person(2, "miguel", new Date(), 3, 4));
		listPerson.add(new Person(2, "juan", new Date(), 3, 4));
		listPerson.add(new Person(2, "camilo", new Date(), 3, 4));
		
		Mockito.when(repository.findAll()).thenReturn(listPerson);
		
		String url = "/api/persons";
		
		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		String expectedJsonResponse = objectMapper.writeValueAsString(listPerson);
		
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
	}
	
	@Test
	public void testCreatePerson() throws JsonProcessingException, Exception {
		Person newPerson = new Person(2, "andres", new Date(), 3, 4);
		String url ="/api/persons";
		Mockito.when(repository.save(newPerson)).thenReturn(newPerson);
		mockMvc.perform(post(url).contentType("application/json")
				.content(objectMapper.writeValueAsString(newPerson))
				).andExpect(status().isOk());
	}
}
