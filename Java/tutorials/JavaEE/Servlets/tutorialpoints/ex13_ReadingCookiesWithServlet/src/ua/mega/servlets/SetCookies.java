package ua.mega.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Setting Cookies with Servlet
 * Let us modify our Form Example to set the cookies for first and last name
 */
public class SetCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create cookies for first and last names.
        Cookie firstName = new Cookie("first_name", req.getParameter("first_name"));
        Cookie lastName = new Cookie("last_name", req.getParameter("last_name"));
        // Set expiry date after 24 Hrs for both the cookies.
        firstName.setMaxAge(60 * 60 * 24);
        lastName.setMaxAge(60 * 60 * 24);
        // Add both the cookies in the response header.
        resp.addCookie(firstName);
        resp.addCookie(lastName);

        // Set response content type
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        String title = "Setting Cookies Example";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + req.getParameter("first_name") + "\n" +
                "  <li><b>Last Name</b>: "
                + req.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }
}
