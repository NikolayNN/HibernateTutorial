package mapping.manytomany;

import mapping.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GetCourseForMaryDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            Query query = session.createQuery("from Student where firstName=:name");
            query.setParameter("name", "mary");
            Student student = (Student) query.getSingleResult();

            System.out.println("courses \n" + student.getCourses());

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            factory.close();
        }

    }
}
