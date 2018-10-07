package com.schoolofnet.helpdesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotEmpty(message = "Must be not empty")
	private String name;

	@Column
	@Email(message = "Por favor informe um email valido")
	@NotEmpty(message = "Must be not empty")
	private String email;

	@Column
	@NotEmpty(message = "Must be not empty")
	private String lastName;

	@Column
	@NotEmpty(message = "Must be not empty")
	@Length(min = 5, max = 15, message = "You need to provide a password that contains at least 5 characters ")
	private String password;

	@Column
	private boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User() {
		super();
	}

	public User(Long id, String name, String email, String lastName, String password, boolean active) {
		this.name = name;
		this.email = email;
		this.lastName = lastName;
		this.password = password;
		this.active = active;
	}

	public User(String name, String email, String lastName, String password, boolean active) {
		this.name = name;
		this.email = email;
		this.lastName = lastName;
		this.password = password;
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
