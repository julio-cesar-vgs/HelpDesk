package com.schoolofnet.helpdesk.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.models.Role;
import com.schoolofnet.helpdesk.models.User;
import com.schoolofnet.helpdesk.repository.RolesRepository;
import com.schoolofnet.helpdesk.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RolesRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserServiceImpl(UserRepository userRepository, RolesRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User create(User user) {
		// funcao para codificar a senha do usuario.
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

		Role userRole = this.roleRepository.findByName("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

		return this.userRepository.save(user);
	}

	@Override
	public Boolean delete(Long id) {
		User user = findById(id);
		if (user != null) {
			this.userRepository.delete(user);
			return true;
		}
		return null;

	}

	private User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public Boolean update(Long id, User user) {
		User userExists = findById(id);

		if (userExists != null) {
			userExists.setId(user.getId());
			userExists.setName(user.getName());
			userExists.setActive(user.isActive());
			userExists.setLastName(user.getLastName());
			// sempre usar o user do item e nunca do que usuario que retorna para nao ter um
			// encode de uma senha codificada.
			userExists.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
			userExists.setEmail(user.getEmail());

			Role userRole = this.roleRepository.findByName(user.getRoles().iterator().next().getName());
			userExists.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

			this.userRepository.save(userExists);

			return true;
		}
		return false;
	}

	@Override
	public User show(Long id) {
		return findById(id);
	}

	@Override
	public List<User> findAllWhereRoleEquals(Long role_id) {

		return this.userRepository.findAllWhereRoleEquals(role_id);

	}

}
