package com.my.tutorial.hibernate.crudsamples.task8.solution;

import com.my.tutorial.hibernate.crudsamples.task8.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
