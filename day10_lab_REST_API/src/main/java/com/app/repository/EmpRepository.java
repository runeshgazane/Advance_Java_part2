package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long> {

}
