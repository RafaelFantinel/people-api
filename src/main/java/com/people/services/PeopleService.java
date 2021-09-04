package com.people.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
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

	public Page<People> findAll(Pageable pageable) {
		return peopleRepository.findAll(pageable);
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
