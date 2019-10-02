package org.kushal.hibernate;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.kushal.hibernate.entity.Users;

public class App {

	public static void main(String[] args) {
		final Logger LOG = Logger.getLogger(App.class.getName());

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Scanner sc = new Scanner(System.in);
		try {
			session.beginTransaction();
			// Fetching all records
			Query query = session.createQuery("from users");
			query.setFirstResult(4); // It skips first 4 rows and fetches the record from table and fetches the
										// records after the 4th row.
			query.setMaxResults(4); // This tels hibernate to fetch only the 4 records
			List<Users> listUsers = query.getResultList();
			// here thr users will the name of the user which is given as the parameter in
			// Entity annotation in Entity class, if
			// we have given the name of the Table using the annotation @Table and not using
			// any parameter in @Entity then here we
			// will use the name of the class(Entity class)

			listUsers.forEach(i -> System.out.println(i));
			System.out.println("*****************");

			Query query1 = session.createQuery("select userdId from users"); // We can also use the slect in HQL to get
																				// the specific column instrad of
																				// getting the the whole object.
			// In this we need to make sure we pass the dataMember but not the column name
			List<String> userIds = (List<String>) query1.getResultList();
			userIds.forEach(j -> System.out.println(j));

			// Parameter in HQL.
			int userId = 0;
			String userName = "Kushal";
			Query query2 = session.createQuery("from users where userId > ? and userName = ?");
			query2.setInteger(0, userId);
			query2.setString(1, userName);
			// In above the HQL ? is a place Holder in Query and query.setInteger Or
			// query.setString in first argument we give the position of the place holder

			int userId1 = 0;
			String userName1 = "Kushal";
			Query query3 = session.createQuery("from users where userId > :userId and userName = :userName1");
			query3.setInteger("userId", userId);
			query3.setString("userName1", userName);
			// Instrad of giving the position we can give the name of the Property.

			// Use of where clause
			List<Users> listUser = session.createQuery("from users where username='Hello'").getResultList();
			listUser.forEach(z -> System.out.println(z));
			System.out.println("*****************");

			// update Query
			session.createQuery("update users set email='kushal2507@gmail' where username='Kushal2507'")
					.executeUpdate();

			// delete Query
			session.createQuery("delete from users where username='M'").executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error in Transaction");
		} finally {
			factory.close();
			session.close();
			sc.close();

		}

	}

}
