package com.people;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.people.dtos.PeopleDto;
import com.people.models.Contact;
import com.people.models.People;

@SpringBootTest
@AutoConfigureMockMvc
class PeopleTests {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void insertPeople() {

		try {
			String nome = "Pessoa teste";
			String cpf = "03845241098";
			LocalDate data_nascimento = LocalDate.of(2010, 3, 7);

			String contact_nome = "Contato 1";
			String contact_telefone = "111458796";
			String contact_email = "teste@teste.com";

			PeopleDto peopleDto = new PeopleDto(nome, cpf, data_nascimento, null);
			People peopleModel = new People();
			BeanUtils.copyProperties(peopleDto, peopleModel);

			List<Contact> contact = new ArrayList<Contact>();
			contact.add(new Contact(0, contact_nome, contact_telefone, contact_email, peopleModel));

			mockMvc.perform(post("/create-people").contentType("application/json")
					.content(objectMapper.writeValueAsString(peopleDto))).andExpect(status().isOk());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	void getAllPeoples() {

		try {

			mockMvc.perform(get("/peoples")).andExpect(status().isOk());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	void getOnePeopleById() {

		try {

			mockMvc.perform(get("/peoples").param("id", "518")).andExpect(status().isOk());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	void removePeople() {

		try {

			mockMvc.perform(MockMvcRequestBuilders.delete("/peoples/{id}", "524")).andExpect(status().isOk());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	void updatePeople() {

		try {
			String nome = "Pessoa ATUALIZADA";
			String cpf = "03845241098";
			LocalDate data_nascimento = LocalDate.of(2010, 3, 7);

			String contact_nome = "Contato ATUALIZADO";
			String contact_telefone = "111458796";
			String contact_email = "teste@teste.com";

			PeopleDto peopleDto = new PeopleDto(nome, cpf, data_nascimento, null);
			People peopleModel = new People();
			BeanUtils.copyProperties(peopleDto, peopleModel);

			List<Contact> contact = new ArrayList<Contact>();
			contact.add(new Contact(0, contact_nome, contact_telefone, contact_email, peopleModel));

			mockMvc.perform(put("/peoples/{id}", "518").contentType("application/json")
					.content(objectMapper.writeValueAsString(peopleDto))).andExpect(status().isOk());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
