package servlets;

import beans.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static logic.servicesForDataBase.ServicesForUserDB.addPersonToBase;
import static logic.ServicesForDispatcher.doDispatcherAndForward;
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
        String cantBeEmpty =" can not be empty.";

        if (isEmpty(firstName)) error = error + " FirstName"+cantBeEmpty;
        if (isEmpty(lastName)) error = error + " SecondName"+cantBeEmpty;
        if (isEmpty(email)) error = error + " Email"+cantBeEmpty;
        if (isEmpty(phone)) phone = "";
        if (isNotEmail(email)) error = error + " " + "Email address not valid.";

        if (error.equals("")) {
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setEmail(email);
            person.setPhoneNumber(phone);

            addPersonToBase(person);
            doDispatcherAndForward("jspS/main.jsp", request, response);
        }
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("error", error);
        doDispatcherAndForward("jspS/registrationSecondStep.jsp", request, response);
    }
}
