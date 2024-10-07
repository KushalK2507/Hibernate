package org.hibernate;

import java.util.List;
import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Customer;
import org.hibernate.query.Query;

public class App {

  @SuppressWarnings("deprecation")
  public static void main(String[] args) {
    SessionFactory sessionFactory =
        new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();

    Session session = null;
    // Scanner sc = new Scanner(System.in);
    //
    // Random number = new Random();
    // String telephoneNumber = null;
    // for (int i = 0; i < 5; i++) {
    // session = sessionFactory.openSession();
    // System.out.print("Enter Name");
    // String name = sc.next();
    // System.out.println("Enter network Provider from valid List");
    // String validNetworkProvider = "Airtel,Jio,BSNL,Voda";
    // String networkProvider = sc.next();
    // if (!validNetworkProvider.contains(networkProvider)) {
    // throw new RuntimeException("Invalid Network Provider");
    // }
    // if ("Airtel".equals(networkProvider)) {
    // telephoneNumber = "8".concat(String.valueOf(number.nextInt(9000000)));
    // } else if ("Jio".equals(networkProvider)) {
    // telephoneNumber = "7".concat(String.valueOf(number.nextInt(9000000)));
    // } else if ("BSNL".equals(networkProvider)) {
    // telephoneNumber = "9".concat(String.valueOf(number.nextInt(9000000)));
    // } else if ("Voda".equals(networkProvider)) {
    // telephoneNumber = "6".concat(String.valueOf(number.nextInt(9000000)));
    // }
    // System.out.println("Enter Pincode");
    // String pinCode = sc.next();
    // Customer c = new Customer();
    // c.setName(name);
    // c.setNetworkProvider(networkProvider);
    // c.setTelephoneNumber(telephoneNumber);
    // c.setPinCode(pinCode);
    // session.beginTransaction();
    // session.save(c);
    // session.getTransaction().commit();
    // session.close();
    //
    // }
    //

    session = sessionFactory.openSession();

    Query createQuery = session.createQuery("from Customer");
    List<Customer> resultList = createQuery.getResultList();

    System.out.println("List Of all Customer");
    resultList.forEach(i -> System.out.println(i));
    System.out.println("----------------------------");

    Query createQuery2 =
        session.createQuery("from Customer where network_Provider = :networkProvider");
    createQuery2.setParameter(
        "networkProvider", "Airtel"); // setString("networkProvider", "Airtel");
    List<Customer> resultList2 = createQuery.getResultList();

    System.out.println("List of Customer where network provider is Airtel");
    resultList2.forEach(j -> System.out.println(resultList));
    System.out.println("----------------------------");

    Query createQuery3 =
        session.createQuery(
            "select name from Customer where telephoneNumber like :telephoneNumber");
    createQuery3.setParameter("telephoneNumber", "9%");
    List<String> resultList3 = (List<String>) createQuery3.getResultList();

    System.out.println("Customer Name whose number start with 9");
    resultList3.forEach(k -> System.out.println(resultList3));
    System.out.println("----------------------------");

    Query namedQuery = session.getNamedQuery("allCustmers");
    List<Customer> resultList4 = namedQuery.getResultList();

    System.out.println("Named Query to get all Customer");
    resultList4.forEach(l -> System.out.println(l));
    System.out.println("----------------------------");

    Query namedQuery2 = session.getNamedQuery("customerByNetworkProvider");
    namedQuery2.setParameter("networkProvider", "Voda");
    List<Customer> resultList5 = namedQuery2.getResultList();

    System.out.println("Customer by Named Query which has network Provider as Voda");
    resultList5.forEach(a -> System.out.println(a));
    System.out.println("----------------------------");

    Query namedNativeQuery = session.getNamedNativeQuery("customerByTelephoneNumber");
    namedNativeQuery.setParameter("telephoneNumber", "6%");
    List<String> resultList6 = (List<String>) namedNativeQuery.getResultList();

    System.out.println("Customer by Native Query whose telephone Number starwith 6");
    resultList6.forEach(s -> System.out.println(s));
    System.out.println("----------------------------");

    Query namedNativeQuery2 = session.getNamedNativeQuery("customerNameByNetworkProvider");
    namedNativeQuery2.setParameter("networkProvider", "BSNL");
    List<Customer> resultList7 = namedNativeQuery2.getResultList();

    System.out.println("Customer Name by Native Query whose networkProvider is BSNL");
    resultList7.forEach(d -> System.out.println(d));
    System.out.println("----------------------------");

    //    Criteria createCriteria = session.createCriteria(Customer.class);
    //    List<Customer> list = createCriteria.list();
    //    System.out.println("All Customer using Criteria");
    //    list.forEach(d -> System.out.println(d));
    //    System.out.println("----------------------------");
    //
    //    Criteria createCriteria2 = session.createCriteria(Customer.class);
    //    Criteria result =
    //        createCriteria2
    //            .setProjection(
    //                Projections.projectionList()
    //                    .add(Projections.property("customerId"))
    //                    .add(Projections.property("name")))
    //            .add(Restrictions.ne("networkProvider", "Airtel"));
    //    List<Object[]> list2 = result.list();
    //    list2.forEach(
    //        g -> {
    //          System.out.println("Customer Id: " + g[0] + " Customer Name: " + g[1]);
    //        });
    //    System.out.println("----------------------------");
    //    // Using QueryByExample
    //    Customer c = new Customer();
    //    c.setNetworkProvider("Airtel");
    //    c.setTelephoneNumber("8%");
    //    Example example = Example.create(c).enableLike();
    //
    //    Criteria criteria = session.createCriteria(Customer.class).add(example);
    //    List<Customer> list3 = criteria.list();
    //    System.out.println("Query By example");
    //    list3.forEach(f -> System.out.println(f));
    System.out.println("----------------------------");
  }
}
