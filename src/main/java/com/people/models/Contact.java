package com.people.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	@NotBlank(message = "Preencha o campo Nome")
	@NotNull(message = "Preencha o campo Nome")
	private String nome;

	@Column
	@NotBlank(message = "Preencha o campo Telefone")
	@NotNull(message = "Preencha o campo Telefone")
	private String telefone;

	@Email
	@Column
	@NotBlank(message = "Preencha o campo E-mail")
	@NotNull(message = "Preencha o campo E-mail")
	private String email;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_people")
	private People people;
	

	public Contact(long id, String nome, String telefone, @Email String email, People people) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.people = people;
	}

	public Contact() {
		super();
	}

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

}
