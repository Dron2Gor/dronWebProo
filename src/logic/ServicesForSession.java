package logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ServicesForSession {

    public static Boolean isLogedInSession(HttpServletRequest request) {
        Boolean isLogIn = false;
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogIn") != null)
            isLogIn = Boolean.parseBoolean(session.getAttribute("isLogIn").toString());
        return isLogIn;
    }

    public static void addFirstNameToSession(String firstName, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("firstName", firstName);

    }

    public static void addLoginNameToSession(String loginName, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("loginName", loginName);

    }

    public static void addPasswordToSession(String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("password", password);
    }

    public static String getLoginNameFromSession(HttpServletRequest request) {
        String loginName;
        HttpSession session = request.getSession();
        if (session.getAttribute("loginName") != null)
            loginName = (String) session.getAttribute("loginName");
        else loginName = "guest";
        return loginName;
    }

    public static String getFirstNameFromSession(HttpServletRequest request) {
        String firstName="guest";
        HttpSession session = request.getSession();
        if (session.getAttribute("firstName") != null)
            firstName = (String) session.getAttribute("firstName");

        return firstName;
    }


}
