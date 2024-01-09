package com.abk.candidatemanagement.service.impl;

import org.springframework.stereotype.Service;

import com.abk.candidatemanagement.model.Role;
import com.abk.candidatemanagement.repo.RoleRepo;
import com.abk.candidatemanagement.service.RoleManagementService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleManagementServiceImpl implements RoleManagementService {

	private final RoleRepo roleRepo;

	@Override
	public Role creatRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public Role readRoleById(Integer roleId) {
		return roleRepo.findById(roleId).orElseThrow();
	}

	@Override
	public Role modifyRole(Role role) {
		return roleRepo.saveAndFlush(role);
	}

	@Override
	public void removeRoleById(Integer roleId) {
		roleRepo.deleteById(roleId);
	}

}
