package com.abk.candidatemanagement.service;

import com.abk.candidatemanagement.model.Role;

public interface RoleManagementService {

	Role creatRole(Role role);
	Role readRoleById(Integer roleId);
	Role modifyRole(Role role);
	void removeRoleById(Integer roleId);
}
