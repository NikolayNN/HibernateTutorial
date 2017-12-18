package mapping.onetoone.samples;

import mapping.entity.Instructor;
import mapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class createInstructorDemo {

    public static void main(String[] args) {

        Instructor instructor = new Instructor();
        instructor.setFirstName("Madhu");
        instructor.setLastName("Patel");
        instructor.setEmail("madhu@gmail.com");
        instructor.setInstructorDetail(new InstructorDetail("youtube.channel", "code"));

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }
}
