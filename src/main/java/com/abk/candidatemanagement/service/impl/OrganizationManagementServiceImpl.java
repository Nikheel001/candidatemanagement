package com.abk.candidatemanagement.service.impl;

import org.springframework.stereotype.Service;

import com.abk.candidatemanagement.model.Organization;
import com.abk.candidatemanagement.repo.OrganizationRepo;
import com.abk.candidatemanagement.service.OrganizationManagementService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrganizationManagementServiceImpl implements OrganizationManagementService {

	private final OrganizationRepo organizationRepo;

	@Override
	public Organization createOneOrganization(Organization organization) {
		return organizationRepo.save(organization);
	}

}
