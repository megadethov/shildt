package ua.mega.domain;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String enrollmentID;
    private String name;
    @ManyToOne
    @JoinColumn(name="TUTOR_FK")
    private Tutor supervisor;

    /**
     * Required by Hibernate
     */
    public Student() {
    }

    /**
     * Initialises a student with a particular supervisor
     */
    public Student(String name, Tutor supervisor) {
        this.name = name;
        this.supervisor = supervisor;
    }
    /**
     * Initialises a student with no pre set tutor 
     */
    public Student(String name, String enrollmentID) {
        this.name = name;
        this.enrollmentID = enrollmentID;
       /* this.supervisor = null;*/
    }

    public double calculateGradePointAverage () {
        // some complex business logic!
        // we won't need this method on the course, BUT it is import
        // to remember that classes aren't just get/set pairs - we expect
        // business logic in here as well.  
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public String getEnrollmentID() {
        return enrollmentID;
    }

    public void allocateSupervisor(Tutor myTutor) {
        this.supervisor = myTutor;
        myTutor.getModifiableGroup().add(this);
    }

    public String getSupervisorName() {
        return this.supervisor.getName();
    }

    public Tutor getSupervisor() {
        return supervisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
