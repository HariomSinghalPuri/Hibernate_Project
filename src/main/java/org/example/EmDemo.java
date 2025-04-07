package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Embeddable;


public class EmDemo {
    public static void main(String[] args) {
        System.out.println("Project Started ....");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // --- Student 1 ---
        Student student1 = new Student();
        student1.setId(1234);
        student1.setName("Amit Kumar");
        student1.setCity("Kolkata");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Software Development");
        certificate1.setDuration("2 Months");
        student1.setCerti(certificate1);

        // --- Student 2 ---
        Student student2 = new Student();
        student2.setId(1235);
        student2.setName("Sumit Kumar");
        student2.setCity("Delhi");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Android Development");
        certificate2.setDuration("2.5 Months");
        student2.setCerti(certificate2);

        // Open session and save both students
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Students saved successfully!");
    }
}
