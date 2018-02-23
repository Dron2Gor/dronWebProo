package logic;

import javax.servlet.http.HttpServletRequest;

import static logic.ServicesForCockie.*;
import static logic.ServicesForSession.*;


public class AutoLogIn {

    public static void doAutoLogIn(HttpServletRequest request) {
        String loginName = getLoginNameFromCookie(request);
        String password = getPasswordFromCookie(request);
        String firstName = getFirstNameFromCookie(request);
        if (!loginName.equals("") & !password.equals("")) {
            addLoginNameToSession(loginName, request);
            addPasswordToSession(password, request);
            addFirstNameToSession(firstName,request);
            request.getSession().setAttribute("isLogIn", true);
        }
    }
}
