package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.servive.EmployeeService;

@RestController// @Controller+@ResponseBody
@CrossOrigin("http://localhost:3000")//enables cors header
@RequestMapping("/employees")

public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	public EmployeeController() {
		System.out.println("in EmpController ctor"+getClass());
	}
	
	@GetMapping
	public List<Employee> getEmps(){
		return empService.getAllEmpDetails();
		
	}
	
	//url ==> http://host:port/employees, method=post
	@PostMapping
	public Employee addEmployee(@RequestBody Employee emp) {
		System.out.println("in addemployee controller"+emp);
		return empService.addNewEmp(emp);
	}
}
