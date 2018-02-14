package servlets;

import beans.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static logic.ServicesForDataBase.isLoginInBase;
import static logic.ServicesForDispatcher.doDispatch;
import static logic.ServicesForFields.isEmpty;

@WebServlet("/RegistrationFirstStep")
public class RegistrationFirstStep extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("password_repeat");
        String regFirstStepPath =  "jspS/registrationFirstStep.jsp";
        String regSecondStepPath =  "jspS/registrationSecondStep.jsp";

        if (isEmpty(loginName)) {
            request.setAttribute("error", "login can not be empty");
            doDispatch(regFirstStepPath,request,response);
        }

        if (isLoginInBase(loginName)) {
            request.setAttribute("error", "such login is already in use");
            doDispatch(regFirstStepPath,request,response);

        } else if (!isEmpty(password) & passwordRepeat.equals(password)) {
            Person person = new Person();
            person.setLogin(loginName);
            person.setPassword(password);

            request.getSession().setAttribute("person", person);
            doDispatch(regSecondStepPath,request,response);

        } else {
            request.setAttribute("loginName", loginName);
            request.setAttribute("error", "Passwords do not match");
            doDispatch(regFirstStepPath,request,response);
        }
    }
}
