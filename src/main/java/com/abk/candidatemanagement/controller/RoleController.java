package com.abk.candidatemanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.dto.RoleDto;
import com.abk.candidatemanagement.service.RoleManagementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {

	private final RoleManagementService roleManagementService;

	@PostMapping
	public RoleDto createRole(@Valid @RequestBody RoleDto role) {
		return roleManagementService.creatRole(role);
	}

	@GetMapping("{roleId}")
	public ResponseEntity<RoleDto> fetchRole(@PathVariable Integer roleId) {
		return ResponseEntity.ok(roleManagementService.readRoleById(roleId));
	}

	@PutMapping("{roleId}")
	public RoleDto modifyRole(@PathVariable Integer roleId,@Valid @RequestBody RoleDto role) {
		return roleManagementService.modifyRole(roleId, role);
	}

	@DeleteMapping("{roleId}")
	public void deleteRole(@PathVariable Integer roleId) {
		roleManagementService.removeRoleById(roleId);
	}
}
