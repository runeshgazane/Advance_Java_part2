package com.app.servive;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
	List<Employee> getAllEmpDetails();
	Employee addNewEmp(Employee newEmp);
}
