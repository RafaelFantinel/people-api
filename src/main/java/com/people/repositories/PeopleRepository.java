package com.people.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people.models.People;

public interface PeopleRepository extends JpaRepository<People, Long> {



}
