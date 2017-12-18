package mapping.onetoone.samples;

import mapping.entity.Instructor;
import mapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class deleteInstructorDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        int theId = 1;

        try{
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, theId);

            if(instructor != null) {
                session.delete(instructor);
            }
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
