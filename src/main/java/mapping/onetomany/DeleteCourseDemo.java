package mapping.onetomany;

import mapping.entity.Course;
import mapping.entity.Instructor;
import mapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            int theId = 18;
            Course course = session.get(Course.class, theId);
            session.delete(course);

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }

    }
}
