package com.abk.candidatemanagement.service;

import com.abk.candidatemanagement.dto.RoleDto;

public interface RoleManagementService {

	RoleDto creatRole(RoleDto role);
	RoleDto readRoleById(Integer roleId);
	RoleDto modifyRole(Integer roleId, RoleDto role);
	void removeRoleById(Integer roleId);
}
