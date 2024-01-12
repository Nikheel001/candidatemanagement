package com.abk.candidatemanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.dto.OrganizationDto;
import com.abk.candidatemanagement.service.OrganizationManagementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/organization")
public class OrganizationController {

	private final OrganizationManagementService organizationManagementService;

	@PostMapping
	public OrganizationDto createOrganization(@Valid @RequestBody OrganizationDto organization) {
		return organizationManagementService.createOneOrganization(organization);
	}
}
