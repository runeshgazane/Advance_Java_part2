package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "new_emps")
//lombok anno
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true ,exclude = "password")
public class Employee extends BaseEntity{
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 20, nullable = false)
	private String password;
	@Column(length = 30)
	//@JsonProperty(value = "location")
	private String location;
	@Column(length = 20)
	private String department;
	private LocalDate joinDate;
	private double salary;
}
