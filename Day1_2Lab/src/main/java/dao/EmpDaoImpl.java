package dao;

import org.hibernate.*;

import pojos.Department;
import pojos.Employee;
import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {

	@Override
	public String addNewEmp(Employee newEmp) {
		String msg = "Employee not added!!!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(newEmp);
			msg = "Employee added successfully..";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			throw e;
			}
		}
		return msg;
	}

	@Override
	public List<Employee> getAllEmpByDeptSal(Department dept, double salary) {
		String jpql="select e from Employee e where e.dept=:dept1 and e.salary>:sal";
		List<Employee> empList=new ArrayList<Employee>();
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			empList=session.createQuery(jpql, Employee.class)
					.setParameter("dept1", dept)
					.setParameter("sal", salary)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			throw e;
			}
		}
		return empList;
	}

}
