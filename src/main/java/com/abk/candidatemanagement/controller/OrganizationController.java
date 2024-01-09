package com.abk.candidatemanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.model.Organization;
import com.abk.candidatemanagement.service.OrganizationManagementService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/organization/")
public class OrganizationController {

	private final OrganizationManagementService organizationManagementService;

	@PostMapping
	public Organization createOrganization(@RequestBody Organization organization) {
		return organizationManagementService.createOneOrganization(organization);
	}
}
