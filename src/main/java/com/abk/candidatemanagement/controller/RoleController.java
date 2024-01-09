package com.abk.candidatemanagement.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.model.Role;
import com.abk.candidatemanagement.service.RoleManagementService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/role/")
public class RoleController {

	private final RoleManagementService roleManagementService;

	@PostMapping
	public Role createRole(@RequestBody Role role) {
		return roleManagementService.creatRole(role);
	}
	
	@GetMapping("{roleId}")
	public Role fetchRole(@PathVariable Integer roleId) {
		return roleManagementService.readRoleById(roleId);
	}
	
	@PutMapping
	public Role modifyRole(@RequestBody Role role) {
		return roleManagementService.modifyRole(role);
	}
	
	@DeleteMapping("{roleId}")
	public void deleteRole(@PathVariable Integer roleId) {
		roleManagementService.removeRoleById(roleId);
	}
}
