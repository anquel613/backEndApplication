package com.application.springboot.backend.apirest.models.entity.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.application.springboot.backend.apirest.models.entity.Person;

public interface IPersonDao extends CrudRepository<Person, Long> {

}
