package mapping.onetomanyuni;

import mapping.entity.Course;
import mapping.entity.Instructor;
import mapping.entity.InstructorDetail;
import mapping.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            int theCourseId = 10;
            Course course = session.get(Course.class, theCourseId);

            System.out.println(course.getReviews());
            System.out.println(course);

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }

    }
}
