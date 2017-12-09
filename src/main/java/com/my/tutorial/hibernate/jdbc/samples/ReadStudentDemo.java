package com.my.tutorial.hibernate.jdbc.samples;

import com.my.tutorial.hibernate.jdbc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Daffy", "Dog", "daffy@gmail.com");

            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();

            System.out.println("Done!");
            System.out.println("Generated id: " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("Get complete " + myStudent);
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
