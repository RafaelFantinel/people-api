package com.people.dtos;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.people.models.Contact;


public class PeopleDto {
	
	@NotBlank(message = "Preencha o campo Nome")
	@NotNull(message = "Preencha o campo Nome")
	private String nome;
	
	@NotBlank(message = "Preencha o campo CPF")
	@NotNull(message = "Preencha o campo CPF")
	@CPF
	private String cpf;
	
    @JsonFormat(pattern = "dd/MM/yyyy")
	@PastOrPresent(message= "Datas futuras são inválidas")
    @NotNull
	private LocalDate data_nascimento;

	@NotEmpty(message= "Informe ao menos 1 contato")
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
