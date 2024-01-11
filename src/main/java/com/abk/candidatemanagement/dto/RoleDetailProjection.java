package com.abk.candidatemanagement.dto;

import java.util.List;

/**
 * 
 */
public interface RoleDetailProjection {

	Integer getRoleId();

	String getName();
	
	List<EmployeeDto> getEmployees();
}