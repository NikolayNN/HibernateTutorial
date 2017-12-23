package mapping.manytomany;

import mapping.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {
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
            Course tempCourse = new Course("Pacman how to score one million points");

            Student tempStudent1 = new Student("John", "Doe", "jonh@gmail.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");

            session.save(tempCourse);

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            session.save(tempStudent1);
            session.save(tempStudent2);

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            factory.close();
        }

    }
}
