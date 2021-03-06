package ua.mega.testharness;

import com.sun.org.apache.regexp.internal.RE;

import ua.mega.domain.Address;
import ua.mega.domain.Student;
import ua.mega.domain.Subject;
import ua.mega.domain.Tutor;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Set;

public class HibernateTestHarness {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");

    public static void main(String[] args) {

        setUpData();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        /*CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        // from clause
        Root<Student> root = criteria.from(Student.class);
        Query q = em.createQuery(criteria);
        List<Student> result = q.getResultList();*/

        /*CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
        criteria.where(builder.equal(root.get("name"), "Marco Fortes"));
        Query q = em.createQuery(criteria);
        List<Student> result = q.getResultList();*/

        /*CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
        Path<Tutor> tutor = root.get("supervisor");
        criteria.where(builder.equal(tutor.get("name"), "David Banks"));
        Query q = em.createQuery(criteria);
        List<Student> result = q.getResultList();*/

        /*CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
//        criteria.where(builder.like(root.get("name"), "%k%"));
        Path<String> propertyName = root.get("name");
        criteria.where(builder.like(propertyName, "%k%"));
        Query q = em.createQuery(criteria);
        List<Student> result = q.getResultList();*/

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Tutor> criteria = builder.createQuery(Tutor.class).distinct(true);
        Root<Tutor> root = criteria.from(Tutor.class);
        Join<Tutor, Student> students = root.join("supervisionGroup");
        Path<Address> address = students.get("address");
        Path<String> city = address.get("city");
        criteria.where(builder.equal(city, "Georgia"));
        Query q = em.createQuery(criteria);
        List<Tutor> result = q.getResultList();
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
