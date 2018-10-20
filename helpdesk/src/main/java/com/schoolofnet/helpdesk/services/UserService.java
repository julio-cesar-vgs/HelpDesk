package com.schoolofnet.helpdesk.services;

import java.util.List;

import com.schoolofnet.helpdesk.models.User;

public interface UserService {

	public List<User> findAll();

	public User create(User user);
	
	public Boolean delete(Long id);
	
	public Boolean update(Long id, User user);

}