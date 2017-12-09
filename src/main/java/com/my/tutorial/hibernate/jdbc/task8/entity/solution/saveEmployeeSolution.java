package com.my.tutorial.hibernate.jdbc.task8.entity.solution;

import com.my.tutorial.hibernate.jdbc.task8.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class saveEmployeeSolution {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = new Employee("John", "White", "Oracle");
            session.save(employee);

            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
