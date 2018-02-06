package logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ServicesForSession {

    public static Boolean isLogged(HttpServletRequest request) {
        Boolean isLogIn = false;
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogIn") != null)
            isLogIn = Boolean.parseBoolean(session.getAttribute("isLogIn").toString());
        return isLogIn;
    }

    public static void addUserNameToSession(String userName, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);

    }

    public static void addPasswordToSession(String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("password", password);
    }

    public static String getUserNameFromSession(HttpServletRequest request) {
        String userName;
        HttpSession session = request.getSession();
        if (session.getAttribute("userName") != null)
            userName = (String) session.getAttribute("userName");
        else userName = "guest";
        return userName;
    }


}
