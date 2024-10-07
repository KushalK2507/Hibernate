package org.kushal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kushal.hibernate.entity.Users;

public class App {

  public static void main(String[] args) {

    SessionFactory factory =
        new Configuration().configure().addAnnotatedClass(Users.class).buildSessionFactory();
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
    Users user = newSession.get(Users.class, 1);
    user.setEmail("Hello");
    Users user1 = newSession.get(Users.class, 2);

    newSession.getTransaction().commit();
    newSession.close();
    factory.close();
  }
}
