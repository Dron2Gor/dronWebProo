package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static logic.ServicesForCockie.*;

@WebServlet("/SingingIn")
public class SengingIn extends HttpServlet {
    private RequestDispatcher requestDispatcher;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("login");
        String password = request.getParameter("password");
        Boolean isLogged;

        if (userName.equals("Dron") & password.equals("6666")) {

            addUserNameToCookie(userName,response);
            addPasswordToCookie(password,response);

            isLogged = true;
            request.getSession().setAttribute("isLogged", isLogged);

            requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        } else {

            request.setAttribute("error", "Name or password is incorrect");
            requestDispatcher = request.getRequestDispatcher("/jspS/singingIn.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
