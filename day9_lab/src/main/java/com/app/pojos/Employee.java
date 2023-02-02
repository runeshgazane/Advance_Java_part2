package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee extends BaseEntity {
	@Column(name = "emp_name", length = 30)
	private String empName;
	@Column(length = 50)
	private String address;
	private double salary;
	private LocalDate joinDate;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department myDepartment;
	
	public Employee() {
		super();
	}

	public Employee(String empName, String address, double salary, LocalDate joinDate) {
		super();
		this.empName = empName;
		this.address = address;
		this.salary = salary;
		this.joinDate = joinDate;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", address=" + address + ", salary=" + salary + ", joinDate=" + joinDate
				+ "]";
	}
	
	
}
