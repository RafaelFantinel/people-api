package com.people.dtos;

import java.util.List;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import com.people.models.Contact;


public class PeopleDto {
	@NotBlank
	private String nome;
	@NotBlank
	@CPF
	private String cpf;
	
	private List<Contact> contacts;
	
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
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
