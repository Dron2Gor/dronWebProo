package logic;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicesForCockie {

    public static void addUserNameToCookie(String userName, HttpServletResponse response) {
        Cookie cookie = new Cookie("userName", userName);
        response.addCookie(cookie);
    }

    public static void addPasswordToCookie(String password, HttpServletResponse response) {
        Cookie cookie = new Cookie("password", password);
        response.addCookie(cookie);
    }

    public static String getUserNameFromCookie(HttpServletRequest request) {
        String userName = "";
        Cookie[] cookies = request.getCookies();
        if (cookies!=null)
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userName")) userName = cookie.getValue();
        }
        return userName;
    }
    public static String getPasswordFromCookie(HttpServletRequest request) {
        String password = "";
        Cookie[] cookies = request.getCookies();
        if (cookies!=null)
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("password")) password = cookie.getValue();
        }
        return password;
    }
}
