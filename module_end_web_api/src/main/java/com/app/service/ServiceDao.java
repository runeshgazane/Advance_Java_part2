package com.app.service;

import java.util.List;

import com.app.custom_exception.EmployeeNotFoundException;
import com.app.dto.EmployeeDto;
import com.app.pojos.Employee;

public interface ServiceDao {
	Employee addEmployee(Employee emp);

	List<Employee> getAllEmployees();

	Employee validateUser(EmployeeDto emp);

	Employee updateEmployee(Employee emp) throws EmployeeNotFoundException;

	String deleteEmployee(Long empId);
}
