package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDaoimpl implements DeptDao{
	@Autowired
	private EntityManager mgr;
	
	@Override
	public List<String> getAllDepartments() {
		String jpql="select d.deptName from Department d";
		return mgr.createQuery(jpql, String.class).getResultList();
	}

}
