package com.people.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	public Optional<People> findPeopleById(Long id) {
		return peopleRepository.findById(id);
	}

	public People updatePeoeple(Long id, People people) {
		People peopleSearched = peopleRepository.findById(id).orElse(null);
		people.getContacts().forEach(contact -> contact.setPeople(people));
		BeanUtils.copyProperties(people, peopleSearched, "id");

		return peopleRepository.save(peopleSearched);

	}

	public ResponseEntity<?> removePeople(Long id) {
		return peopleRepository.findById(id).map(record -> {
			peopleRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
