package com.abk.candidatemanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abk.candidatemanagement.model.Role;

import jakarta.transaction.Transactional;

public interface RoleRepo extends JpaRepository<Role, Integer> {

	@Override
	@Transactional
	void deleteById(Integer id);
	
}
