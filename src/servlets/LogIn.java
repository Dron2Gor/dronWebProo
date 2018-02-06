package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static logic.ServicesForCockie.*;
import static logic.ServicesForSession.*;

@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
    private RequestDispatcher requestDispatcher;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (userName.equals("Dron") & password.equals("6666")) {

            addUserNameToCookie(userName,response);
            addPasswordToCookie(password,response);
            addUserNameToSession(userName,request);
            addPasswordToSession(password,request);

            Boolean isLogIn = true;
            request.getSession().setAttribute("isLogIn", isLogIn);

            requestDispatcher = request.getRequestDispatcher("jspS/main.jsp");
            requestDispatcher.forward(request, response);
        } else {

            request.setAttribute("error", "Name or password is incorrect");
            requestDispatcher = request.getRequestDispatcher("/jspS/logIn.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
