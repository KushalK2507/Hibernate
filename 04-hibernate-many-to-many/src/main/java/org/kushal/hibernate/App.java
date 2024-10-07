package org.kushal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kushal.hibernate.entity.Persons;
import org.kushal.hibernate.entity.Vehicle;

public class App {

  public static void main(String[] args) {

    SessionFactory sessionFactory =
        new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Persons.class)
            .addAnnotatedClass(Vehicle.class)
            .buildSessionFactory();

    Session session = sessionFactory.getCurrentSession();

    Persons person1 = new Persons();
    person1.setName("Kushal");

    Persons person2 = new Persons();
    person2.setName("Komal");

    Vehicle vehicle = new Vehicle();
    vehicle.setVehicleName("Jeep");

    Vehicle vehicle2 = new Vehicle();
    vehicle2.setVehicleName("Car");

    person1.getVehicle().add(vehicle);
    person1.getVehicle().add(vehicle2);
    person2.getVehicle().add(vehicle);
    person2.getVehicle().add(vehicle2);

    vehicle.getPerson().add(person1);
    vehicle.getPerson().add(person2);
    vehicle2.getPerson().add(person1);
    vehicle2.getPerson().add(person2);

    session.beginTransaction();

    session.save(person1);
    session.save(vehicle);
    session.save(vehicle2);

    session.getTransaction().commit();
    session.close();
    System.out.println("Programs Ends");
    System.exit(0);
  }
}
