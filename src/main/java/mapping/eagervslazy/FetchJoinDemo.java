package mapping.eagervslazy;

import mapping.entity.Course;
import mapping.entity.Instructor;
import mapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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

            int theId = 1;

            Query<Instructor> query = session.createQuery("select i from Instructor i " +
                    "JOIN FETCH i.courses " +
                    "where i.id =:theInstructorId", Instructor.class);
            query.setParameter("theInstructorId", theId);

            Instructor instructor = query.getSingleResult();

            session.getTransaction().commit();

            session.close();

            System.out.println(instructor.getCourses());

        }finally {
            session.close();
            factory.close();
        }

    }
}
