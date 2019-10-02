package org.kushal.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kushal.hibernate.entity.Address;
import org.kushal.hibernate.entity.Users;

public class App {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter 1 choice");
			System.out.println("Enter 1 to insert into database");
			System.out.println("Enter 2 to retrieve Data from Database");
			System.out.println("Enter 3 to update the Data in Database");
			System.out.println("Enter 4 to delete the Data from Database");
			System.out.println("Enter 5 to exit");
			int choice;
			session.beginTransaction();
			do {
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					sc.nextLine();
					System.out.println("Enter the Username");
					String name = sc.nextLine();
					System.out.println("Enter the Email Address");
					String email = sc.nextLine();
					Users insertUser = new Users(name, email);
					System.out.println("Enter the Home Address details");
					System.out.println("Enter the Street");
					String street = sc.nextLine();
					System.out.println("Enter the State");
					String state = sc.nextLine();
					System.out.println("Enter the City");
					String city = sc.nextLine();
					System.out.println("Enter the pincode");
					String pincode = sc.nextLine();
					Address homeAddress = new Address();
					homeAddress.setCity(city);
					homeAddress.setState(state);
					homeAddress.setStreet(street);
					homeAddress.setPincode(pincode);
					System.out.println("Enter the Company Address details");
					System.out.println("Enter the Street");
					String street1 = sc.nextLine();
					System.out.println("Enter the State");
					String state1 = sc.nextLine();
					System.out.println("Enter the City");
					String city1 = sc.nextLine();
					System.out.println("Enter the pincode");
					String pincode1 = sc.nextLine();
					Address companyAddress = new Address();
					companyAddress.setCity(city1);
					companyAddress.setState(state1);
					companyAddress.setStreet(street1);
					companyAddress.setPincode(pincode1);
					// Adding Simple Home Address
					insertUser.setAddress(homeAddress);

					// Adding Simple Company Address which is newly created in Users class
					insertUser.setCompanyAddress(companyAddress);

					// Inserting the List of Address that 1User can have
					insertUser.getListAddress().add(companyAddress);
					insertUser.getListAddress().add(homeAddress);

					session.save(insertUser);
					System.out.println("Row Added");
					break;

				case 2:
					Users retrieveUser = new Users();
					retrieveUser = session.get(Users.class, 21);
					System.out.println(retrieveUser);
					System.out.println("Data Retrived Successfully");
					break;

				case 3:
					Users updateUser = new Users();
					updateUser = session.get(Users.class, 5);
					updateUser.setUsername("Kushal2507");
					session.save(updateUser);
					updateUser = session.get(Users.class, 0);
					System.out.println(updateUser);
					System.out.println("UserName is updated");
					break;

				case 4:
					Users deleteUser = new Users();
					deleteUser = session.get(Users.class, 1);
					session.delete(deleteUser);
					System.out.println("User deleted");
					break;
				case 5:
					break;
				default:
					System.out.println("Wrong Choice");
					break;
				}

			} while (choice != 5);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
			factory.close();
			sc.close();
		}
	}
}
