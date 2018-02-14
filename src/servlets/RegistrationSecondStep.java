package servlets;

import beans.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static logic.ServicesForDataBase.addPersonToBase;
import static logic.ServicesForDispatcher.doDispatch;
import static logic.ServicesForFields.isEmpty;
import static logic.ServicesForFields.isNotEmail;

@WebServlet("/RegistrationSecondStep")
public class RegistrationSecondStep extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = (Person) request.getSession().getAttribute("person");
        String error = "";
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if (isEmpty(firstName)) error = error + " " + "FirstName can not be empty.";
        if (isEmpty(lastName)) error = error + " " + "SecondName can not be empty.";
        if (isEmpty(email)) error = error + " " + "Email can not be empty.";
        if (isEmpty(phone)) phone = "";
        if (isNotEmail(email)) error = error + " " + "Email address not valid.";

        if (error.equals("")) {
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setEmail(email);
            person.setPhoneNumber(phone);

            addPersonToBase(person);
            doDispatch("jspS/main.jsp", request, response);
        }
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("error", error);
        doDispatch("jspS/registrationSecondStep.jsp", request, response);
    }
}
