package com.abk.candidatemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
	
	private Integer orgId;

	@NotBlank
	private String name;
}