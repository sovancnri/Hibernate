package com.nri;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestFirstLevelCache {
	public static void main(String[] args) {
		System.out.println("Hibernate First Level Cache is enabled by default");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session sone = factory.openSession();

		Transaction tx = sone.beginTransaction();

//		Employee empobj = new Employee();
//		empobj.setEmpid(11);
//		empobj.setEmpname("Sehnaz");
//		empobj.setEmpcity("Delhi");

		Employee empone = sone.get(Employee.class, 11);
		System.out.println(empone);

		
		
		 

//		sone.save(empobj);

		tx.commit();

		sone.close();

		Session stwo = factory.openSession();
		Transaction tx2 = stwo.beginTransaction();
		Employee emptwo = stwo.get(Employee.class, 11); 
		System.out.println(emptwo);
		
		tx2.commit();
		
		factory.close();
	}
}
