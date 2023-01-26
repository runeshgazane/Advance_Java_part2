package tester;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmpDaoImpl;
import pojos.Department;
import pojos.Employee;

public class TestAddEmp {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); Scanner sc=new Scanner(System.in);){
			System.out.println("Hibernate up and running!!!");
			EmpDaoImpl empDao=new EmpDaoImpl();
			System.out.println("Enter emp details : firstName,  lastName,  " 
					+ "dept,  salary,  dob, isPermanent");
					// create transient emp
			Employee emp = new Employee(sc.next(), sc.next(), 
							Department.valueOf(sc.next().toUpperCase()),
							sc.nextDouble(), LocalDate.parse(sc.next()),
							sc.nextBoolean());
					//invoke dao's method
			System.out.println(empDao.addNewEmp(emp));
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
