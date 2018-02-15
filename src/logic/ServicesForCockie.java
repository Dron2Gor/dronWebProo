package logic;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicesForCockie {

    public static void addLoginNameToCookie(String loginName, HttpServletResponse response) {
        Cookie cookie = new Cookie("loginName", loginName);
        response.addCookie(cookie);
    }

    public static void addPasswordToCookie(String password, HttpServletResponse response) {
        Cookie cookie = new Cookie("password", password);
        response.addCookie(cookie);
    }
    public static String getLoginNameFromCookie(HttpServletRequest request) {
        String loginName = "";
        Cookie[] cookies = request.getCookies();
        if (cookies!=null)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginName")) loginName = cookie.getValue();
            }
        return loginName;
    }

    public static String getFirstNameFromCookie(HttpServletRequest request) {

        String firstName = "guest";
        Cookie[] cookies = request.getCookies();
        if (cookies!=null)
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("firstName")) firstName = cookie.getValue();
        }
        return firstName;
    }
    public static void addFirstNameToCookie(String firstName, HttpServletResponse response) {
        Cookie cookie = new Cookie("firstName", firstName);
        response.addCookie(cookie);
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
