package com.abk.candidatemanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abk.candidatemanagement.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
