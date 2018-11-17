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
		return this.roleRepository.findAll();
	}

	@Override
	public Role create(Role role) {
		Role roleCreated = this.roleRepository.save(role);
		return roleCreated;
	}

	@Override
	public Boolean delete(Long id) {
		Role role = findById(id);
		if (role != null) {
			this.roleRepository.delete(role);
			
			return true;
		}

		return false;
	}

	private Role findById(Long id) {

		return this.roleRepository.findOne(id);

	}

	@Override
	public Role findByName(String name) {
return this.roleRepository.findByName(name);	}
}
