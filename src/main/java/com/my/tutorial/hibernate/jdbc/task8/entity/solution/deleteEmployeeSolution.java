package com.my.tutorial.hibernate.jdbc.task8.entity.solution;

import com.my.tutorial.hibernate.jdbc.task8.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class deleteEmployeeSolution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);

            session.delete(employee);

            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
