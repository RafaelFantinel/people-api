package com.people.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people.models.People;
import com.people.repositories.PeopleRepository;

@Service
public class PeopleService {
	@Autowired
	private PeopleRepository peopleRepository;

	public People save(People people) {
		people.getContacts().forEach(contact -> contact.setPeople(people));

		return peopleRepository.save(people);
	}

	public List<People> findAll() {

		return peopleRepository.findAll();
	}

}
