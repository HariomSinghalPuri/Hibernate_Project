package Com.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        System.out.println("Project Started ....");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();


        // Creating Question
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is Java ???");

        // Creating Answer:
        Answer answer1 = new Answer();
        answer1.setAnswerId(343);
        answer1.setAnswer("JAVA is a Programming language");
        q1.setAnswer(answer1);

        // Creating Question
        Question q2 = new Question();
        q2.setQuestionId(242);
        q2.setQuestion("What is Collection Framework ???");

        // Creating Answer:
        Answer answer2 = new Answer();
        answer2.setAnswerId(344);
        answer2.setAnswer("API to work with objects in java");
        q2.setAnswer(answer2);

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(q1);
        s.save(q2);
        tx.commit();
        s.close();

        System.out.println(factory);
        System.out.println(factory.isClosed());
        System.out.println("Done........");

    }
}
