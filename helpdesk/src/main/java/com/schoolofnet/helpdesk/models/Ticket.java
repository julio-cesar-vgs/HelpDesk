package com.schoolofnet.helpdesk.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(name = "description")
	private String description;

	private Date created;

	private Date closed;

	private Boolean finished;

	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User userOpen;

	
	@ManyToOne
	@JoinColumn(name = "techinician_id")
	@JsonBackReference
	private User techinician;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getClosed() {
		return closed;
	}

	public void setClosed(Date closed) {
		this.closed = closed;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	public User getUserOpen() {
		return userOpen;
	}

	public void setUserOpen(User userOpen) {
		this.userOpen = userOpen;
	}

	public User getTechinician() {
		return techinician;
	}

	public void setTechinician(User techinician) {
		this.techinician = techinician;
	}

	public Ticket() {
	}
	
	

}
