package tester;
import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import pojos.Course;

public class TestAddNewCourse {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); Scanner sc=new Scanner(System.in);)
		{
			System.out.println("Hibernate up n running !"+sf);
			CourseDaoImpl courseDao=new CourseDaoImpl();
			System.out.println("Enter course details : courseTitle,startDate,endDate,fees,capacity");
			System.out.println(courseDao.addNewCourse(new Course(sc.next(),parse(sc.next()),
					parse(sc.next()),sc.nextDouble(),sc.nextInt())));
		} //JVM : sf.close() => DB cn pool is cleaned up...
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
