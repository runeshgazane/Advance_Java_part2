package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dao.DeptDao;

@Controller
public class DepartmentController {
	@Autowired
	private DeptDao deptDao;
	
	public DepartmentController() {
		System.out.println("in dept controller ctor"+getClass());
	}
	
	@GetMapping("/")
	public String getAllDepartments(Model map) {
		System.out.println("in getAllDepartments() of dept controller");
		map.addAttribute("dept_list",deptDao.getAllDepartments());
		return "/department/dept";
	}
}
