package com.abk.candidatemanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abk.candidatemanagement.entity.Organization;

public interface OrganizationRepo extends JpaRepository<Organization, Integer> {

}
