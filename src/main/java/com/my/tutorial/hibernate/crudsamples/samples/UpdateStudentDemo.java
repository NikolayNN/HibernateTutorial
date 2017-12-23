package com.my.tutorial.hibernate.crudsamples.samples;

import mapping.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();

            System.out.println("Getting student with id: " + studentId);
            Student student = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            student.setFirstName("Scooby");

            session.getTransaction().commit();

            //another way

            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
