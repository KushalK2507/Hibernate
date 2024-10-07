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
		Query query = session.getNamedQuery("Users.byID"); // Here we give the name of the Named Query given in
															// Entity class
		query.setInteger("id", 1);
		List<Users> users = query.getResultList();
		users.forEach(i -> System.out.println(i));

		Query query1 = session.getNamedNativeQuery("Users.byName");
		query1.setString("name", "User0");
		List<Users> user = query.getResultList();
		user.forEach(i -> System.out.println(i));

		// Creating the Criteria for fetching the records
		Criteria criteria = session.createCriteria(Users.class);
		criteria.add(Restrictions.eq("username", "User2")).add(Restrictions.gt("userId", 5));
		List<Users> user5 = criteria.list();
		user5.forEach(i -> System.out.println(i));

		Criteria projection = session.createCriteria(Users.class).setProjection(Projections.property("userId"))
				.addOrder(Order.asc("userId"));

		Users userdetails = new Users();
		userdetails.setUserId(2);
		
		Example example = Example.create(userdetails);

		Criteria queryByExample = session.createCriteria(Users.class).add(example);

		session.getTransaction().commit();
		session.close();
		factory.close();

	}

}
