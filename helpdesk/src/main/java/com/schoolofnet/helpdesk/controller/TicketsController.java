package com.schoolofnet.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.helpdesk.models.Role;
import com.schoolofnet.helpdesk.models.Ticket;
import com.schoolofnet.helpdesk.services.RoleService;
import com.schoolofnet.helpdesk.services.UserService;

@Controller
@RequestMapping("/tickets")
public class TicketsController {

//	private final Long ROLE_ID = 1l;

//	@Autowired
//	private TicketService ticketService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@GetMapping
	public String create(Model model) {
		model.addAttribute("ticket", new Ticket());

		Role adminRole = this.roleService.findByName("admin");
		//pega informacao dinamica
		model.addAttribute("techs", this.userService.findAllWhereRoleEquals(adminRole.getId()));

//		model.addAttribute("techs", this.userService.findAllWhereRoleEquals(ROLE_ID));
		return "ticket/create";
	}

}
