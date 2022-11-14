package com.nri;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class I_TestORMBasic {
	public static void main(String[] args) {
		System.out.println("Hibernate Started.....");

		// We need object of configuration class
		Configuration config = new Configuration();
		// we need to configure session for Hibernate
		SessionFactory factory = config.configure().buildSessionFactory(); //
		Session session = factory.openSession();

		Customer custobj = new Customer();
		custobj.setCustid(21);
		custobj.setCustname("Neha");
		custobj.setCustcity("Kolkata");

		
		Orders ordobj = new Orders();
		ordobj.setOrdid(51);
		ordobj.setOrdname("Farm Fresh Pizza");
		ordobj.setOrdprice(800);
		
		custobj.setOrder(ordobj);
		// Now we need to start transaction before asking hibernate to save out object
		// into db
		Transaction tx = session.beginTransaction();

        session.save(custobj);

		/*
		 * Customer cone = (Customer)session.get(Customer.class, 22);
		 * 
		 * System.out.println(cone);	-- Eager Loading
		 */
//		Customer cone = (Customer) session.load(Customer.class, 12);
//		System.out.println(cone);		-- Lazy Loading

		tx.commit();

//        System.out.println(session);

		session.close();
		factory.close();
	}
}
