package com.app.servive;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Employee;
import com.app.repository.EmpRepository;

@Service
@Transactional // readOnly: false
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmpRepository empRepo;

	@Override
	public List<Employee> getAllEmpDetails() {
		return empRepo.findAll();
	}

	@Override
	public Employee addNewEmp(Employee newEmp) {
		return empRepo.save(newEmp);
	}

}
