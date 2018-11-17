package com.schoolofnet.helpdesk.services;

import java.util.List;

import com.schoolofnet.helpdesk.models.Ticket;

public interface TicketService {

	public List<Ticket> findAll();

	public Ticket create(Ticket ticket);

	public Boolean delete(Long id);

	public Boolean update(Long id, Ticket ticket);

	public Ticket show(Long id);
}
