package com.nri;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class Test1to1Mapping 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate Mapping Started ...." );
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        Customer cone = new Customer();
        cone.setCustid(11);
        cone.setCustname("Mac");
        cone.setCustcity("Delhi");
        
        Customer ctwo = new Customer();
        ctwo.setCustid(12);
        ctwo.setCustname("Krishna");
        ctwo.setCustcity("Kolkata");
        
        Orders ordone = new Orders();
        ordone.setOrdid(51);
        ordone.setOrdname("Chocolate Donut");
        ordone.setOrdprice(400);
        ordone.setCustomer(cone);
        
        Orders ordtwo = new Orders();
        ordtwo.setOrdid(52);
        ordtwo.setOrdname("Veg Pizza");
        ordtwo.setOrdprice(600);
        ordtwo.setCustomer(ctwo);
        
        session.save(ordone);
        session.save(ordtwo);
        
        cone.setOrder(ordone);
        ctwo.setOrder(ordtwo);
        
        session.save(cone);
        session.save(ctwo);
        
        tx.commit();
        
        session.close();
        factory.close();
    }
}
