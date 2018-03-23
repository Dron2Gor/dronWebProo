package logic;

import org.apache.commons.codec.digest.DigestUtils;

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

    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("dron"));
        if (DigestUtils.md5Hex("dron").equals("fd0e9133c7efd5ccd54f6bf79147db8f")) System.out.println("Yes !!!");
    }
}
