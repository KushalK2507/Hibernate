package org.kushal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kushal.hibernate.entity.Users;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		Users user = new Users();
		user.setUserName("Kushal"); // At this time user object is transient object and not persistent as it is yet
									// not persisted in DB.

		
		session.getTransaction();
		session.save(user); // At this time user object is persistent and hibernate tracks this object and
							// saves it.

		user.setUserName("Hello"); // At this time hibernate will run the uppdate statement update the user
									// information in table.
		// Hibernate will up keep updating the same user and the state of the user that
		// is last OR just before commit will be saved in DB.

		// Before the close of the session the user object is persistent object and
		// responsible to Hibernate to track it's changes.

		session.getTransaction().commit();

		user.setUserName("After Comit"); // This updation will not reflect in the DB as session is closed.
		// After the session is closed the object becomes the detached object and
		// changes not it will not be tracked by Hibernate.

	}

}
