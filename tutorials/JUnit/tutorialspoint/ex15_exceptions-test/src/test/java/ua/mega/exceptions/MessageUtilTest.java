package ua.mega.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageUtilTest {

    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);


    @Test(expected = ArithmeticException.class)
    public void printMessage() throws Exception {
        System.out.println("Inside testPrintMessage()");
        messageUtil.printMessage();
    }

    @Test
    public void salutationMessage() throws Exception {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Robert";
        assertEquals(message,messageUtil.salutationMessage());

    }

}