package ua.mega.domain;

public class Student {
    private String enrollmentID;
    private String name;
    private String tutorName; // This will become a class soon 

    /**
     * Initialises a student with a particular tutor
     */
    public Student(String name, String tutorName) {
        this.name = name;
        this.tutorName = tutorName;
    }
    /**
     * Initialises a student with no pre set tutor 
     */
    public Student(String name) {
        this.name = name;
        this.tutorName = null;
    }

    public double calculateGradePointAverage () {
        // some complex business logic!
        // we won't need this method on the course, BUT it is import
        // to remember that classes aren't just get/set pairs - we expect
        // business logic in here as well.  
        return 0;
    }
}
