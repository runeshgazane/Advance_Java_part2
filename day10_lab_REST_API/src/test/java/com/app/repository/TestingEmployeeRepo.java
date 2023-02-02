package com.app.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.pojos.Employee;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class TestingEmployeeRepo {
	@Autowired
	private EmpRepository empRepo;
	@Test
	void test() {
		assertNotNull(empRepo);
	}
	
	@Test
	void testAddMultipleEmployees() {
		List<Employee> empList=List.of(
				new Employee("Runesh","Gazane","rg@gmail.com","1234","Pune","RnD",LocalDate.parse("2023-01-25"),50000),
				new Employee("Saurav","Patil","sp@gmail.com","1234","Mumbai","Development",LocalDate.parse("2023-01-10"),60000));
		List<Employee> savedEmpList=empRepo.saveAll(empList);
		assertEquals(2, savedEmpList.size());
	}

}
