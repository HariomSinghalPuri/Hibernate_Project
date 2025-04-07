package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Date;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Project Started ....");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        // Creating Student
        Student st = new Student();
        st.setId(101);
        st.setName("Singhal");
        st.setCity("Jhumri Telaiya");

        System.out.println(st);

        //Creating Object of address class
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);


        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();



        System.out.println(factory);
        System.out.println(factory.isClosed());
        System.out.println("Done........");



    }
}

