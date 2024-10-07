package org.kushal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kushal.hibernate.entity.FourWheeler;
import org.kushal.hibernate.entity.TwoWheeler;
import org.kushal.hibernate.entity.Vehicle;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Vehicle.class)
				.addAnnotatedClass(TwoWheeler.class).addAnnotatedClass(FourWheeler.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringHandle("Pulsar");

		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Car");
		fourWheeler.setSteeringWheel("M G Hector");

		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		session.getTransaction().commit();
		session.close();
		factory.close();

	}

}
