package tester;
import static utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmpDaoImpl;
import pojos.Department;
import pojos.Employee;

public class TestGetEmpByDeptSal {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); Scanner sc=new Scanner(System.in);){
			System.out.println("Hibernate up and running!!!");
			EmpDaoImpl empDao=new EmpDaoImpl();
			System.out.println("Enter emp dept and salary : ");
					// create transient emp
					//invoke dao's method
			List<Employee> empList=empDao
					.getAllEmpByDeptSal(Department.valueOf(sc.next().toUpperCase()),sc.nextDouble());
			empList.forEach(System.out::println);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
