package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;

public class CourseDaoImpl implements CourseDao{

	@Override
	public String addNewCourse(Course newCourse) {
		String mesg = "Adding Course failed!!!!";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(newCourse);
			tx.commit();
			mesg = "New course added with ID " + newCourse.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
