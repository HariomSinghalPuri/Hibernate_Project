package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        // Creating Student
        Student st = new Student();
        st.setId(101);
        st.setName("Singhal");
        st.setCity("Jhumri Telaiya");
        System.out.println(st);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        tx.commit();
        session.close();



        System.out.println(factory);
        System.out.println(factory.isClosed());



    }
}

