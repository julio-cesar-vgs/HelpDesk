package com.schoolofnet.helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.models.Role;
import com.schoolofnet.helpdesk.repository.RolesRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RolesRepository roleRepository;

	public RoleServiceImpl(RolesRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> findAll() {
		return null;
	}

	@Override
	public Role create(Role role) {
		Role roleCreated = this.roleRepository.save(role);
		return roleCreated;
	}

}
