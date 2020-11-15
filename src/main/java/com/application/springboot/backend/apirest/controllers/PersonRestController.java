package com.application.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.springboot.backend.apirest.models.entity.Person;
import com.application.springboot.backend.apirest.models.entity.models.services.IPersonService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PersonRestController {
	
	@Autowired
	private IPersonService personService;
	
	@GetMapping("/persons")
	public List<Person> index() {
		return personService.findAll();
	}
	
	@GetMapping("/persons/{id}")
	public Person show(@PathVariable Long id) {
		return personService.findById(id);
	}
	
	@PostMapping("/persons")	
	public Person create(@RequestBody Person person) {
		return personService.save(person);
	}
	
	@PutMapping("/persons/{id}") 
	public Person update(@RequestBody Person person, @PathVariable Long id) {
		Person actualPerson = personService.findById(id);
		
		actualPerson.setBirth(person.getBirth());
		actualPerson.setFatherId(person.getFatherId());
		actualPerson.setFullname(person.getFullname());
		actualPerson.setMotherId(person.getMotherId());
		
		return personService.save(actualPerson);
	}
	
	@DeleteMapping("/persons/{id}")
	public void delete(@PathVariable Long id) {
		personService.delete(id);
	}
}