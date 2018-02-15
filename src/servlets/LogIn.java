package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static logic.ServicesForCockie.*;
import static logic.ServicesForDataBase.*;
import static logic.ServicesForDispatcher.doDispatch;
import static logic.ServicesForSession.*;

@WebServlet("/LogIn")
public class LogIn extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = "";
        String loginName = request.getParameter("loginName");
        String firstName;
        String password = request.getParameter("password");

        if (isLoginInBase(loginName)) {
            String passwordFromBase = getPasswordFromBase(loginName);
            if (password.equals(passwordFromBase)) {

                firstName = getFirstNameFromBase(loginName);
                addLoginNameToCookie(loginName, response);
                addPasswordToCookie(password, response);
                addFirstNameToCookie(firstName, response);

                addFirstNameToSession(firstName, request);
                addLoginNameToSession(loginName, request);
                addPasswordToSession(password, request);

                Boolean isLogIn = true;
                request.getSession().setAttribute("isLogIn", isLogIn);

                doDispatch("jspS/main.jsp", request, response);

            } else
                error = "Password is incorrect";
        } else
            error = "User " + loginName + " is not registered";

        request.setAttribute("error", error);
        doDispatch("/jspS/logIn.jsp", request, response);

    }
}
