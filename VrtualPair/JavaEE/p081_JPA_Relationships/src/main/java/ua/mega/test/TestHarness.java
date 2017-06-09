package ua.mega.test;

import ua.mega.staffmanagement.domain.Employee;
import ua.mega.staffmanagement.domain.Note;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestHarness {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeDB");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Employee employee = new Employee("Vasya", "Pupkin", "Java coder", 1000);
        em.persist(employee);

        Note note = new Note("Joined to Company");
        em.persist(note);

        employee.addNote(note);

        tx.commit();
        em.close();
    }
}