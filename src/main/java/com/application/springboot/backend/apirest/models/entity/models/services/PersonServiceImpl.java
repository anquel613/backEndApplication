package com.application.springboot.backend.apirest.models.entity.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.springboot.backend.apirest.models.entity.Person;
import com.application.springboot.backend.apirest.models.entity.models.dao.IPersonDao;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonDao personDao;
	@Override
	@Transactional(readOnly = true)
	public List<Person> findAll() {
		return (List<Person>) personDao.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Person findById(long id) {
		return personDao.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public Person save(Person person) {
		// TODO Auto-generated method stub
		return personDao.save(person);
	}
	@Override
	@Transactional
	public void delete(long id) {
		// TODO Auto-generated method stub
		personDao.deleteById(id);
	}
		
	
}
