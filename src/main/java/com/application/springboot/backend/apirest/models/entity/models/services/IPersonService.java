package com.application.springboot.backend.apirest.models.entity.models.services;

import java.util.List;

import com.application.springboot.backend.apirest.models.entity.Person;

public interface IPersonService {

	public List<Person> findAll();
	
	public Person findById(long id);
	
	public Person save(Person person);
	
	public void delete (long id);
	
}
