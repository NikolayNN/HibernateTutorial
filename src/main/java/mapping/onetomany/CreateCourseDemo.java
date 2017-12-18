package mapping.onetomany;

import mapping.entity.Course;
import mapping.entity.Instructor;
import mapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Course course1 = new Course("10x123");
        Course course2 = new Course("first or last123");

        try{

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1);

            instructor.setFirstName("QWERTY");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);



            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }

    }
}
