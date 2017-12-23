package com.my.tutorial.hibernate.crudsamples.samples;

import mapping.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").list();
            System.out.println("all students");
            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName='Doe'").list();
            System.out.println("\nStudents who have last name of Doe");
            displayStudents(students);

            students = session.createQuery("from Student s " +
                    "where s.lastName='Doe' OR s.firstName='Daffy'").list();
            System.out.println("\nStudents who have last name of Doe or first name Daffy");
            displayStudents(students);

            students = session.createQuery("from Student s where s.email LIKE '%e@gmail.com'").list();
            System.out.println("\nStudent who have email ends with e@gmail.com");
            displayStudents(students);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
