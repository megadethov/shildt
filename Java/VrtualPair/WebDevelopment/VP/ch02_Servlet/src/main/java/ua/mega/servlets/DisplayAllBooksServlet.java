package ua.mega.servlets;

import ua.mega.domain.Book;
import ua.mega.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DisplayAllBooksServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        HttpSession session = req.getSession(); // need to encodeURL()

        // do some work
        BookService bookService = BookService.getService();
        List<Book> allBooks = bookService.getEntireCatalogue();
        // output the result page
        out.print("<html><head><title>Our entire catalogue</title>");
        out.print("<body><h1>Our entire catalogue</h1>");
        out.print("<ul>");
        for (Book next : allBooks) {
            out.print("<li>");
            out.print(next.getTitle());
            // add to Card
            String url = "AddToCart.html";
            url = resp.encodeURL(url); // if cookie is disabled (plan B)

            out.print("<form method='get' action='" + url + "'>");
            out.print("<input type='hidden' name='id' value='" + next.getId() + "'/>");
            out.print("<input type='submit' value='Add Book to Cart'/>");
            out.print("</form>");
            out.print("</li>");
        }
        out.print("</ul>");
        out.print("</body></html>");

        out.close();
    }
}
