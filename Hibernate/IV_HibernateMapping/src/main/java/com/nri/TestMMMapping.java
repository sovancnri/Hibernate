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
public class TestMMMapping 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate Mapping MM Started ...." );
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        Customer cone = new Customer();
        cone.setCustid(21);
        cone.setCustname("Mehak");
        cone.setCustcity("Delhi");
        
        Customer ctwo = new Customer();
        ctwo.setCustid(22);
        ctwo.setCustname("Rohan");
        ctwo.setCustcity("Noida");
        
        Orders ordone = new Orders();
        ordone.setOrdid(61);
        ordone.setOrdname("Chocolate Donut");
        ordone.setOrdprice(400);
        
        Orders ordtwo = new Orders();
        ordtwo.setOrdid(62);
        ordtwo.setOrdname("Veg Pizza");
        ordtwo.setOrdprice(600);
        
        List<Customer> listcust = new ArrayList<Customer>();
        listcust.add(cone);
        listcust.add(ctwo);
        
        List<Orders> listord = new ArrayList<Orders>();
        listord.add(ordone);
        listord.add(ordtwo);
        
        cone.setOrder(listord);
        ctwo.setOrder(listord);
       
        ordone.setCustomer(listcust);
        ordtwo.setCustomer(listcust);
        
        session.save(ordone);
        session.save(ordtwo);
        
        session.save(cone);
        session.save(ctwo);
        
        tx.commit();
        
        session.close();
        factory.close();
    }
}
