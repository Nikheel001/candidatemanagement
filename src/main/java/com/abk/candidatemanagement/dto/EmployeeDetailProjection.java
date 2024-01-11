package com.abk.candidatemanagement.dto;

/**
 * 
 */
public interface EmployeeDetailProjection {

	Integer getEmpId();

	Integer getAge();

	String getEmail();

	String getMobileno();

	String getName();

	DepartmentDto getDepartment();

	RoleDto getRole();

	SuborganizationDto getSuborganization();

}