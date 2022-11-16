package com.nri;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class TestHQLApp {
	static Configuration cfg;
	static SessionFactory sf;
	static Session s;
	static Transaction tx;

	private static Session getSession() {
		cfg = new Configuration().configure().addAnnotatedClass(Trainees.class).addAnnotatedClass(Laptop.class);
		sf = cfg.buildSessionFactory();
		s = sf.openSession();
		return s;
	}

	private static void rcrCreate() {
		Laptop lapone = new Laptop();
		lapone.setLappyid(51);
		lapone.setLappyname("Dell");

		Trainees tone = new Trainees();
		tone.setTid(21);
		tone.setTname("Rohan");
		tone.setLaptop(lapone);
		tone.setTmarks(700);

		Laptop ltwo = new Laptop();
		ltwo.setLappyid(52);
		ltwo.setLappyname("Lenovo");

		Trainees ttwo = new Trainees();
		ttwo.setTid(22);
		ttwo.setTname("Mini");
		ttwo.setTmarks(800);
		ttwo.setLaptop(ltwo);

		Laptop lthree = new Laptop();
		lthree.setLappyid(53);
		lthree.setLappyname("MacBook");

		Trainees tthree = new Trainees();
		tthree.setTid(23);
		tthree.setTname("John");
		tthree.setTmarks(900);
		tthree.setLaptop(lthree);

		s = getSession();
		tx = s.beginTransaction();

		s.save(lapone);
		s.save(ltwo);
		s.save(lthree);

		s.save(tone);
		s.save(ttwo);
		s.save(tthree);

		tx.commit();
		s.close();
	}

	private static void rcrRetrieveAll() {
		s = getSession();

		// SQL -> select * from tablename;
		// HQL -> from classname
		Query query = s.createQuery("from Trainees");

		List<Trainees> listtr = query.getResultList();

		for (Trainees t : listtr) {
			System.out.println(t + " ");
		}
		System.out.println();
		s.close();
	}

	private static void rcrRetrieveUnique(int trid) {
		s = getSession();

		// SQL -> Select * from tablename where colname = ? == HQL -> from classname
		// where variablename = :NamedParameter
		Query query = s.createQuery("from Trainees where tid = :traineeid");
		query.setLong("traineeid", trid);

		Trainees tr = (Trainees) query.uniqueResult();

		System.out.println(tr + " ");
		s.close();
	}

	private static void rcrUpdate(int trid, String trname) {
		s = getSession();
		tx = s.beginTransaction();

		Query query = s.createQuery("update Trainees set tname = :traineename where tid= :traineeid");
		query.setLong("traineeid", trid);
		query.setString("traineename", trname);

		int count = query.executeUpdate();

		System.out.println(count + " recod got updated");
		tx.commit();
		s.close();
	}

	private static void rcrDelete(int trid) {
		s = getSession();
		tx = s.beginTransaction();

		Query query = s.createQuery("delete Trainees where tid = :trid");
		query.setLong("trid", trid);

		int count = query.executeUpdate();

		System.out.println(count + " recod got deleted");
		tx.commit();
		s.close();
	}

	// Criteria API - These are used for querying on the columns
	private static void projectionFirst() {
		s = getSession();
		double sumtotalmarks = (Double) s.createCriteria(Trainees.class).setProjection(Projections.sum("tmarks"))
				.uniqueResult();

		System.out.println("Sum total of trainees marks column as projected is " + sumtotalmarks);
		s.close();

	}
	private static void projectionSecond() {
		s = getSession();
		long totalcount = (Long)s.createCriteria(Trainees.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("tname", "%o%"))
				.uniqueResult();
		
		System.out.println("Total Number of trainees with 'o' in name as projected is "+totalcount);
		s.close();
		
	}
	public static void main(String[] args) {
		System.out.println("Hibernate Trainees - Laptop Tracking CRUD ");
//        rcrCreate();
//        rcrRetrieveAll();
//        rcrRetrieveUnique(22);
//        rcrUpdate(23,"John Cena");
//		projectionFirst();
		projectionSecond();

	}
}
