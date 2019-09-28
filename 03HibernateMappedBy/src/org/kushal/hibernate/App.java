package org.kushal.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kushal.hibernate.entity.House;
import org.kushal.hibernate.entity.Persons;
import org.kushal.hibernate.entity.Vehicle;

public class App {

	public static void main(String args[]) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Persons.class).addAnnotatedClass(House.class).addAnnotatedClass(Vehicle.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		Scanner sc = new Scanner(System.in);

		Persons person = new Persons();
		System.out.println("Enter the Person's Name");
		person.setName(sc.next());

		House house = new House();
		System.out.println("Enter the House Name");
		house.setHouseName(sc.next());
		person.setHouse(house);

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Jeep");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Car");

		// Below is implementated for OneToMany mapping
		person.getVehicle().add(vehicle);
		person.getVehicle().add(vehicle2);

		// Below implements for ManyToOne mapping
		vehicle.setPerson(person);
		vehicle2.setPerson(person);

		session.beginTransaction();
		session.save(house);
		session.save(person);
		session.save(vehicle);
		session.save(vehicle2);

		session.getTransaction().commit();
		session.close();
		System.out.println("Programs Ends");
		sc.close();
		System.exit(0);

	}

}
