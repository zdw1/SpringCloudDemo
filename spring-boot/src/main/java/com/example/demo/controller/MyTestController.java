package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;

@RestController
public class MyTestController {
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPerson(@PathVariable Integer id) {
		Person person = new Person();
		person.setId(id);
		person.setName("haha");
		person.setAge(22);
		return person;
	}
}
