package com.application.springboot.backend.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.application.springboot.backend.apirest.controllers.PersonRestController;
import com.application.springboot.backend.apirest.models.entity.Person;
import com.application.springboot.backend.apirest.models.entity.models.dao.IPersonDao;
import com.application.springboot.backend.apirest.models.entity.models.services.IPersonService;
import com.application.springboot.backend.apirest.models.entity.models.services.PersonServiceImpl;

@SpringBootApplication
public class SpringBootBackendApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApirestApplication.class, args);
	}

}
