package com.nri;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class Test1M1Mapping 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate Mapping 1M1 Started ...." );
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        Customer cone = new Customer();
        cone.setCustid(21);
        cone.setCustname("Mehak");
        cone.setCustcity("Delhi");
        
        
        Orders ordone = new Orders();
        ordone.setOrdid(61);
        ordone.setOrdname("Chocolate Donut");
        ordone.setOrdprice(400);
        ordone.setCustomer(cone);
        
        Orders ordtwo = new Orders();
        ordtwo.setOrdid(62);
        ordtwo.setOrdname("Veg Pizza");
        ordtwo.setOrdprice(600);
        ordtwo.setCustomer(cone);
        
        session.save(ordone);
        session.save(ordtwo);
        
        List<Orders> listord = new ArrayList<Orders>();
        listord.add(ordone);
        listord.add(ordtwo);
        
        cone.setOrder(listord);
        
        session.save(cone);
        
        tx.commit();
        
        session.close();
        factory.close();
    }
}
