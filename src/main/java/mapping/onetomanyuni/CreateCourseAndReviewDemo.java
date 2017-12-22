package mapping.onetomanyuni;

import mapping.entity.Course;
import mapping.entity.Instructor;
import mapping.entity.InstructorDetail;
import mapping.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {

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
            Course tempCourse = new Course("Pacman how to score one million points");
            tempCourse.addReview(new Review("Good course ... loved it"));
            tempCourse.addReview(new Review("Cool course, well done"));
            tempCourse.addReview(new Review("What a ump course? you are an idiot!"));

            session.save(tempCourse);
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }

    }
}
