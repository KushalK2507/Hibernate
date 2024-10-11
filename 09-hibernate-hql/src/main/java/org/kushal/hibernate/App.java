package org.kushal.hibernate;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.kushal.hibernate.entity.Users;

public class App {

  public static void main(String[] args) {
    final Logger LOG = Logger.getLogger(App.class.getName());

    SessionFactory factory =
        new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Users.class)
            .buildSessionFactory();
    Session session = factory.getCurrentSession();
    Scanner sc = new Scanner(System.in);
    try {
      session.beginTransaction();
      // Fetching all records
      Query<Users> query = session.createQuery("from users",Users.class);
      query.setFirstResult(
          4); // It skips first 4 rows and fetches the record from table and fetches the
      // records after the 4th row.
      query.setMaxResults(4); // This tels hibernate to fetch only the 4 records
      List<Users> listUsers = query.getResultList();
      // here thr users will the name of the user which is given as the parameter in
      // Entity annotation in Entity class, if
      // we have given the name of the Table using the annotation @Table and not using
      // any parameter in @Entity then here we
      // will use the name of the class(Entity class)

      listUsers.forEach(System.out::println);
      System.out.println("*****************");

      Query<String> query1 =
          session.createQuery(
              "select userdId from users",String.class); // We can also use the slect in HQL to get
      // the specific column instrad of
      // getting the the whole object.
      // In this we need to make sure we pass the dataMember but not the column name
      List<String> userIds = query1.getResultList();
      userIds.forEach(System.out::println);

      // Parameter in HQL.
      int userId = 0;
      String userName = "Kushal";
      Query<Users> query2 = session.createQuery("from users where userId > ? and userName = ?",Users.class);
      query2.setParameter(0, userId);
      query2.setParameter(1, userName);
      // In above the HQL ? is a place Holder in Query and query.setInteger Or
      // query.setString in first argument we give the position of the place holder

      int userId1 = 0;
      String userName1 = "Kushal";
      Query<Users> query3 =
          session.createQuery("from users where userId > :userId and userName = :userName1",Users.class);
      query3.setParameter("userId", userId);
      query3.setParameter("userName1", userName);
      // Instrad of giving the position we can give the name of the Property.

      // Use of where clause
      List<Users> listUser =
          session.createQuery("from users where username='Hello'",Users.class).getResultList();
      listUser.forEach(System.out::println);
      System.out.println("*****************");

      // update Query
      session
          .createQuery("update users set email='kushal2507@gmail' where username='Kushal2507'")
          .executeUpdate();

      // delete Query
      session.createQuery("delete from users where username='M'",Users.class).executeUpdate();
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
