package ua.mega;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp17 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        Contact contact = (Contact) context.getBean("contact");
        contact.getEmailEmpty();
        contact.getEmailNull();
    }
}
