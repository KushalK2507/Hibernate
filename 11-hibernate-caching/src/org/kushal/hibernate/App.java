package org.kushal.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.kushal.hibernate.entity.Users;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Users.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		for (int i = 0; i < 5; i++) {
			Users user = new Users();
			user.setUsername("User" + i);
			user.setEmail("user" + i + "@gmail.com");
			session.save(user);
		}
		session.getTransaction().commit();
		session.close();
		Session newSession = factory.getCurrentSession();
		newSession.beginTransaction();

		// First level of Cahcing.
		// In below we can see Hibernate only firres 1 select and update Query.
		Users user = (Users) newSession.get(Users.class, 1);
		user.setEmail("Hello");
		Users user1 = (Users) newSession.get(Users.class, 2);

		newSession.getTransaction().commit();
		newSession.close();
		factory.close();

	}

}
