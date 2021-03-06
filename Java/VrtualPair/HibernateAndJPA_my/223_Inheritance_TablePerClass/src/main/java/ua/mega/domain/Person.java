package ua.mega.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;

    public Person() {
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    protected String getId() {
        return id;
    }

    protected String getName() {
        return name;
    }

    public abstract void calculateReport();
}
