package logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServicesForFields {

    public static boolean isEmpty(String field) {
        return field.equals("") || field == null;
    }
    public static boolean isNotEmail(String email){
        Pattern pattern=Pattern.compile
                ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher=pattern.matcher(email);

        return !matcher.matches();

    }

    public static void main(String[] args) {
        System.out.println(isNotEmail("danik.jj@dan.com"));
    }
}
