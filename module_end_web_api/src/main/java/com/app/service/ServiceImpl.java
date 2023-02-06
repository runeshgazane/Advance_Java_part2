package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.EmployeeNotFoundException;
import com.app.dto.EmployeeDto;
import com.app.pojos.Employee;
import com.app.repository.RepositoryDao;

@Service
@Transactional
public class ServiceImpl implements ServiceDao {
	@Autowired
	RepositoryDao daoRepo;
	
	@Override
	public Employee addEmployee(Employee emp) {
		return daoRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return daoRepo.findAll();
	}

	@Override
	public Employee validateUser(EmployeeDto emp) {
		Employee employee = daoRepo.findByEmailAndPassword(emp.getEmail(),emp.getPassword());
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeNotFoundException {
		if(daoRepo.existsById(emp.getId())) {
			return daoRepo.save(emp);
		}
		throw new EmployeeNotFoundException("Invalid EmpId!!!");
	}

	@Override
	public String deleteEmployee(Long empId) {
		if(daoRepo.existsById(empId)) {
			daoRepo.deleteById(empId);
			return "Employee deleted successfully...";
		}
		return "Employee deletion failed!!!";
		
	}
	

}
