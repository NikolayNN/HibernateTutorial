package mapping.onetoone.samples;

import mapping.entity.Instructor;
import mapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class biDirectionalOneToOneDeleteDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 4;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

            if (instructorDetail != null) {
                session.delete(instructorDetail);
                System.out.println(instructorDetail.getInstructor());
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
