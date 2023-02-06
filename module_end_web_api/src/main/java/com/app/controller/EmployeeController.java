package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exception.EmployeeNotFoundException;
import com.app.dto.EmployeeDto;
import com.app.pojos.Employee;
import com.app.service.ServiceDao;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	ServiceDao serviceDao;
	
	public EmployeeController() {
		System.out.println("in emp controller ctor");
	}
	
	@PostMapping("/addemp")
	public Employee addNewEmp(@RequestBody Employee newEmp) {
		return serviceDao.addEmployee(newEmp);
	}
	
	@GetMapping
	public List<Employee> getAllEmp(){
		return serviceDao.getAllEmployees();
	}
	
	@PostMapping("/login")
	public Employee loginByEmailAndPassword(@RequestBody EmployeeDto emp) {
		return serviceDao.validateUser(emp);
	}
	
	@PutMapping("/update")
	public Employee updateEmp(@RequestBody Employee emp) throws EmployeeNotFoundException {
		return serviceDao.updateEmployee(emp);
	}
	
	@DeleteMapping("/{empId}")
	public String deleteEmp(@PathVariable Long empId) {
		return serviceDao.deleteEmployee(empId);
	}
}
