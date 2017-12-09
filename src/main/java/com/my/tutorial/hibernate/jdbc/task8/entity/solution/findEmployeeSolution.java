package com.my.tutorial.hibernate.jdbc.task8.entity.solution;

import com.my.tutorial.hibernate.jdbc.task8.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class findEmployeeSolution {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee);

            List<Employee> employees = session.createQuery("from Employee e where e.company = 'Oracle'").list();
            System.out.println(employees);

            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
