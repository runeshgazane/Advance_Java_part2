package dao;

import java.util.List;

import pojos.Department;
import pojos.Employee;

public interface EmpDao {
	String addNewEmp(Employee newEmp);
	List<Employee> getAllEmpByDeptSal(Department dept, double salary);
}
