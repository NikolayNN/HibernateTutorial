package mapping.onetomany;

import mapping.entity.Course;
import mapping.entity.Instructor;
import mapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
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

            Instructor instructor = new Instructor();
            instructor.setFirstName("Grant");
            instructor.setLastName("Cordon");
            instructor.setEmail("grant@gmail.com");
            instructor.setInstructorDetail(new InstructorDetail("youtube.channel", "sale"));

            session.save(instructor);

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }

    }
}
