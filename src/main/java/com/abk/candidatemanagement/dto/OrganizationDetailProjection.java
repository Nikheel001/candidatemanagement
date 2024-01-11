package com.abk.candidatemanagement.dto;

import java.util.List;

/**
 * 
 */
public interface OrganizationDetailProjection {
	
	Integer getOrgId();

	String getName();
	
	List<SuborganizationDto> getSuborganizations();
}