package ua.mega.testharness;

import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import ua.mega.domain.Student;
import ua.mega.domain.Subject;
import ua.mega.domain.Tutor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class HibernateTestHarness {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");

    public static void main(String[] args) {

        String requiredName = "Marco Fortes";

        setUpData();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Session session = (Session) em.getDelegate();

      /*  Criteria criteria = session.createCriteria(Student.class);
        List<Student> result = criteria.list();
        for (Student next : result) {
            System.out.println(next);
        }*/

       /* Criteria criteria = session.createCriteria(Student.class);
//        criteria.add(Restrictions.like("name", "%Marco%"));
        criteria.add(Restrictions.ilike("name", "%mArCo%"));
//        criteria.add(Restrictions.eq("name", "Marco Fortes"));
        List<Student> result = criteria.list();
        for (Student next : result) {
            System.out.println(next);
        }*/

       /* Criteria criteria = session.createCriteria(Student.class);
        List<Student> result = criteria.createCriteria("supervisor").add(Restrictions.eq("name", "David Banks")).list();
        for (Student next : result) {
            System.out.println(next);
        }*/

        /*Criteria criteria = session.createCriteria(Tutor.class);
        criteria.createAlias("supervisionGroup", "student");
        List<Tutor> result = criteria.add(Restrictions.eq("student.address.city", "Georgia")).list();
        for (Tutor next : result) {
            System.out.println(next);
        }*/

        Criteria criteria = session.createCriteria(Tutor.class);
        criteria.createAlias("supervisionGroup", "student");
        criteria.add(Restrictions.eq("student.address.city", "Georgia"));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List<Tutor> result = criteria.list();
        for (Tutor next : result) {
            System.out.println(next);
        }


        tx.commit();
        em.close();
    }

    private static void setUpData() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Some Objects
        Subject mathematics = new Subject("Mathematics", 2);
        Subject science = new Subject("Science", 2);
        Subject history = new Subject("History", 3);
        em.persist(mathematics);
        em.persist(science);
        em.persist(history);

        // This tutor will be very busy, with lots of students 
        Tutor t1 = new Tutor("ABC123", "David Banks", 10000);
        t1.addSubjectToTutor(mathematics);
        t1.addSubjectToTutor(science);

        // This tutor is new and has no students
        // But he will be able to teach science and mathematics
        Tutor t2 = new Tutor("DEF456", "Alan Bridges", 15000);
        t2.addSubjectToTutor(mathematics);
        t2.addSubjectToTutor(science);

        // This tutor is the only tutor who can teach History
        Tutor t3 = new Tutor("GHI678", "Linda Histroia", 20000);
        t3.addSubjectToTutor(history);
        t3.addSubjectToTutor(science);

        em.persist(t1);
        em.persist(t2);
        em.persist(t3);

        // this only works because we are cascading from tutor to student
        t1.createStudentAndAddToSupervisionGroup("Marco Fortes", "1-FOR-2010", "1 The Street", "Georgia", "484848");
        t1.createStudentAndAddToSupervisionGroup("Kath Grainer", "2-GRA-2009", "2 Kaths Street", "Georgia", "939393");
        t3.createStudentAndAddToSupervisionGroup("Sandra Perkins", "3-PER-2009", "4 The Avenue", "Georgia", "939393");


        tx.commit();
        em.close();
    }
}
