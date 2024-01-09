package com.abk.candidatemanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abk.candidatemanagement.model.Department;

import jakarta.transaction.Transactional;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

	@Override
	@Transactional
	void deleteById(Integer id);
}
