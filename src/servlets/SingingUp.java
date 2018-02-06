package servlets;

import beans.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/SingingUp")
public class SingingUp extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("password_repeat");
        String email = request.getParameter("email");

        if (passwordRepeat.equals(password)) {
            Person person = new Person();
            person.setFirstName(login);
            person.setPassword(password);
            person.setEmail(email);
            request.getSession().setAttribute("person", person);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        } else {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jspS/singingUp.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
