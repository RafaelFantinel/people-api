package com.people.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.people.dtos.PeopleDto;
import com.people.models.People;
import com.people.services.PeopleService;

import javassist.NotFoundException;

@RestController
public class PeopleController {

	@Autowired
	private PeopleService peopleService;

	@PostMapping("/create-people")
	public ResponseEntity<People> createPeople(@RequestBody @Valid PeopleDto peopleDto) {
		People peopleModel = new People();
		BeanUtils.copyProperties(peopleDto, peopleModel);

		peopleService.save(peopleModel);

		return new ResponseEntity<>(peopleModel, HttpStatus.CREATED);

	}

	@GetMapping("/peoples")
	public List<People> getAllPeoples() throws NotFoundException {
		return peopleService.findAll();

	}

	@GetMapping("/peoples/{id}")
	public Optional<People> findPeopleById(@PathVariable Long id) throws NotFoundException {
		return peopleService.findPeopleById(id);

	}

	@PutMapping("/peoples/{id}")
	public People updatePeople(@PathVariable Long id, @RequestBody People people) throws NotFoundException {
		return peopleService.updatePeoeple(id, people);

	}

	@DeleteMapping("/peoples/{id}")
	public ResponseEntity<?> removePeople(@PathVariable Long id) throws NotFoundException {
		return peopleService.removePeople(id);
	}
}
