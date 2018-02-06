package logic;

import javax.servlet.http.HttpServletRequest;

import static logic.ServicesForCockie.*;
import static logic.ServicesForSession.*;


public class AutoLogIn {
    public static void doAutoLogIn(HttpServletRequest request) {
        String userName = getUserNameFromCookie(request);
        String password = getPasswordFromCookie(request);
        if (!userName.equals("") & !password.equals("")) {
            addUserNameToSession(userName, request);
            addPasswordToSession(password, request);
            Boolean isLogIn = true;
            request.getSession().setAttribute("isLogIn", isLogIn);
        }
    }
}
