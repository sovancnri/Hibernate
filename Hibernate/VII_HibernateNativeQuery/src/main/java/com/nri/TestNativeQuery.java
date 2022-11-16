package com.nri;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.query.NativeQuery;

public class TestNativeQuery {
	static Configuration cfg;
	static SessionFactory sf;
	static Session s;
	static Transaction tx;
	
	private static Session getSession() {
		cfg = new Configuration();
		sf = cfg.configure().buildSessionFactory();
		s = sf.openSession();
		return s;
	}
	private static void rcrInsert() {
		
		Library libone = new Library();
		libone.setLibid(11);
		libone.setLibname("CS-IT Library");
		libone.setLibfee(700);
		
		Library libtwo = new Library();
		libtwo.setLibid(12);
		libtwo.setLibname("ECE Library");
		libtwo.setLibfee(800);
		
		Library libthree = new Library();
		libthree.setLibid(13);
		libthree.setLibname("Civil Library");
		libthree.setLibfee(800);
		
		s = getSession();
		
		tx = s.beginTransaction();
		
		s.save(libone);
		s.save(libtwo);
		s.save(libthree);
		
		tx.commit();
		s.close();
	}
	
	private static void rcrgetAll() {
		s = getSession();
		
		NativeQuery query = s.createNativeQuery("SELECT * from library");
		
		List<Object[]> listrows = query.getResultList();
		listrows.forEach(libobj->{
			
			for(Object obj: libobj) {
				System.out.println(obj+" ");
			}
			System.out.println();
		});
	}
	private static void rcrSearch(int id) {
		s = getSession();
		
		NativeQuery query = s.createNativeQuery("SELECT * from library where libid=?");
		query.setParameter(1, id);
		
		List<Object[]> listrows = query.getResultList();
		listrows.forEach(libobj->{
			
			for(Object obj: libobj) {
				System.out.println(obj+" ");
			}
			System.out.println();
		});
	}
	private static void rcrUpdate(int lid,String lname) {
		s = getSession();
		tx = s.beginTransaction();
		
		NativeQuery query = s.createNativeQuery("update library set libname=? where libid=?");
		query.setParameter(2, lid);
		query.setParameter(1, lname);
		
		int count = query.executeUpdate();
		System.out.println(count+" record got updated");
		tx.commit();
		s.close();
	}
	private static void rcrDelete(int lid) {
		s = getSession();
		tx = s.beginTransaction();
		
		NativeQuery query = s.createNativeQuery("delete from library where libid = ?");
		query.setParameter(1, lid);
		
		int count = query.executeUpdate();
		System.out.println(count+" record got deleted");
		tx.commit();
		s.close();
	}
	
	
	public static void main(String[] args) {
		System.out.println("Hibernate native query ");
		
//		rcrInsert();
//		rcrgetAll();
//		rcrSearch(12);
//		rcrUpdate(13,"Mechanical");
//		rcrDelete(12);
	}
}
