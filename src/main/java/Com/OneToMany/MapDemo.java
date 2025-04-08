package Com.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class MapDemo {

    public static void main(String[] args) {
        System.out.println("Project Started ....");

        // Answers for Question 1
        Answer answer1 = new Answer(343, "JAVA is a Programming language");
        Answer answer2 = new Answer(344, "With the help of Java we can create software");
        Answer answer3 = new Answer(345, "Java has different type of frameworks");

        Question question1 = new Question();
        question1.setQuestionId(1212);
        question1.setQuestion("What is Java?");
        question1.setAnswers(Arrays.asList(answer1, answer2, answer3));

        // Answers for Question 2
        Answer answer4 = new Answer(346, "Collection is a framework in Java");
        Answer answer5 = new Answer(347, "It contains classes and interfaces like List, Set, Map");

        Question question2 = new Question();
        question2.setQuestionId(1213);
        question2.setQuestion("What is Collection in Java?");
        question2.setAnswers(Arrays.asList(answer4, answer5));

        // Hibernate setup
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class);
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();

        // Save both questions (and their answers)
        session.save(question1);
        session.save(question2);

        session.getTransaction().commit();

        session.close();
        factory.close();

        System.out.println("Data saved successfully.");
    }
}
