package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static logic.ServicesForCockie.*;
import static logic.ServicesForDataBase.*;
import static logic.ServicesForSession.*;

@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
    private RequestDispatcher requestDispatcher;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = "";
        String loginName = request.getParameter("loginName");
        String firstName = "";
        String password = request.getParameter("password");

        if (!isLoginInBase(loginName)) {
            error = "Us`er " + loginName + " is not registered";
            request.setAttribute("error", error);
            requestDispatcher = request.getRequestDispatcher("/jspS/logIn.jsp");
            requestDispatcher.forward(request, response);

        } else if (password.equals(getPasswordFromBase(loginName))) {

            firstName = getFirstNameFromBase(loginName);
            addLoginNameToCookie(loginName, response);
            addPasswordToCookie(password, response);
            addFirstNameToCookie(firstName,response);

            addFirstNameToSession(firstName,request);
            addLoginNameToSession(loginName, request);
            addPasswordToSession(password, request);

            Boolean isLogIn = true;
            request.getSession().setAttribute("isLogIn", isLogIn);

            requestDispatcher = request.getRequestDispatcher("jspS/main.jsp");
            requestDispatcher.forward(request, response);
        } else
            error = "Password is incorrect";
            request.setAttribute("error", error);
            requestDispatcher = request.getRequestDispatcher("/jspS/logIn.jsp");
            requestDispatcher.forward(request, response);
    }
}
