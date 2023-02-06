package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Employee;

public interface RepositoryDao extends JpaRepository<Employee, Long> {

	Employee findByEmailAndPassword(String email, String password);

}
