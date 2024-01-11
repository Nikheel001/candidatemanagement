package com.abk.candidatemanagement.dto;

import java.util.List;

/**
 * 
 */
public interface SuborganizationDetailProjection {

	Integer getSubOrgId();

	String getName();

	List<EmployeeDto> getEmployees();

	OrganizationDto getOrganization();
}