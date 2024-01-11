package com.abk.candidatemanagement.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.abk.candidatemanagement.dto.RoleDto;
import com.abk.candidatemanagement.entity.Role;
import com.abk.candidatemanagement.repo.RoleRepo;
import com.abk.candidatemanagement.service.RoleManagementService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleManagementServiceImpl implements RoleManagementService {

	private final RoleRepo roleRepo;
	private final ModelMapper mapper;

	@Override
	public RoleDto creatRole(RoleDto roleDto) {
		Role role = mapper.map(roleDto, Role.class);
		return mapper.map(roleRepo.save(role), RoleDto.class);
	}

	@Override
	public RoleDto readRoleById(Integer roleId) {
		Role role = roleRepo.findById(roleId).orElseThrow();
		return mapper.map(role, RoleDto.class);
	}

	@Override
	public RoleDto modifyRole(Integer roleId, RoleDto roleDto) {
		Role role = roleRepo.findById(roleId).orElseThrow();
		role.setName(roleDto.getName());
		return mapper.map(roleRepo.saveAndFlush(role), RoleDto.class);
	}

	@Override
	public void removeRoleById(Integer roleId) {
		roleRepo.deleteById(roleId);
	}

}
