package ua.mega.testharness;

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

        /*List<Student> result = em.createNamedQuery("searchByName")
                .setParameter("name", requiredName)
                .getResultList();*/

        /*List<Student> result = em.createQuery("from Student").getResultList();
        for (Student next : result) {
            System.out.println(next.getName());
        }*/

       /* List<String> result = em.createQuery("select student.name from Student as student")
                .getResultList();
        for (String next: result) {
            System.out.println(next);
        }*/

        /*List<Object[]> result = em.createQuery("select student.name, student.enrollmentID from Student as student")
                .getResultList();
        for (Object[] next : result) {
            System.out.println(next[0] + "---" + next[1]);
        }*/

        /*List<Object[]> result = em.createQuery("select student.name, student.supervisor.name from Student as student")
                .getResultList();
        for (Object[] next : result) {
            System.out.println(next[0] + "---" + next[1]);
        }*/

       /* long numberOfstudents = (long) em.createQuery("select count(student) from Student as student")
                .getSingleResult();
        System.out.println("Number of students: " + numberOfstudents);*/

       /* int updateRows = em.createQuery("update Tutor as tutor set tutor.salary = tutor.salary*2")
                .executeUpdate();
        System.out.println(updateRows);*/

      /* List<Object[]> result = em.createNativeQuery("select s.NAME, s.ENROLLMENTID from STUDENT s")
               .getResultList();
        for (Object[] next : result) {
            System.out.println(next[0] + "---" + next[1]);
        }*/

        List<Student> result = em.createNativeQuery("select * from STUDENT s", Student.class)
                .getResultList();
        for (Student next : result) {
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
