package com.people.dtos;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.people.models.Contact;


public class PeopleDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	@CPF
	private String cpf;
	
	@NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_nascimento;

	private List<Contact> contacts;
	
	public PeopleDto(@NotBlank String nome, @NotBlank @CPF String cpf, @NotNull @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data_nascimento,
			List<Contact> contacts) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
		this.contacts = contacts;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public LocalDate getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
