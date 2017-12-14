package com.my.tutorial.hibernate.crudsamples.samples;

import com.my.tutorial.hibernate.crudsamples.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int studentId = 1;
            System.out.println("Getting student with id: " + studentId);
            Student student = session.get(Student.class, studentId);
            session.delete(student);

            //another way

            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
