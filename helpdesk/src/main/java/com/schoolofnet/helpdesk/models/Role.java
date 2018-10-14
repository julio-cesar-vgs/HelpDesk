package com.schoolofnet.helpdesk.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "roles")
//nivel de permissao do projeto
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	@NotEmpty(message = "Can't be empty")
	private String role;

	public Role() {

	}

	public Role(String role, Long id) {
		this.role = role;
		this.id = id;
	}

}