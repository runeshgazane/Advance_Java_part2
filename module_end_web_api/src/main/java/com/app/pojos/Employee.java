package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = "password")
@Table(name = "emp")
public class Employee extends BaseEntity{
	@Column(name = "first_name",length = 20)
	private String firstName;
	@Column(name = "last_name",length = 20)
	private String lastName;
	@Column(length = 50, unique = true)
	private String email;
	@Column(length = 20, nullable = false )
	private String password;
	@Column(length = 20)
	private String location;
	@Column(length = 20)
	private String department;
	private LocalDate joinDate;
	private double salary;
}
