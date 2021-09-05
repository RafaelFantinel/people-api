package com.people.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_people")
public class People {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	@NotBlank(message = "Preencha o campo Nome")
	@NotNull(message = "Preencha o campo Nome")
	private String nome;
	
	@Column
	@NotBlank(message = "Preencha o campo CPF")
	@NotNull(message = "Preencha o campo CPF")
	@CPF
	private String cpf;

	 @JsonFormat(pattern = "dd/MM/yyyy")
	 @PastOrPresent(message= "Datas futuras são inválidas")
	 @NotNull
	private LocalDate data_nascimento;
	
	@JsonIgnoreProperties("people")
	@Valid
	@OneToMany(mappedBy = "people", cascade = CascadeType.ALL)
	@NotEmpty(message= "Informe ao menos 1 contato")
	private List<Contact> contacts;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
