package logic.servicesForDataBase;

import beans.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicesForUserDB extends ServicesForDataBase {
    public static String getPasswordFromBase(String loginName) {
        String password = "";
        try (Statement statement = getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format("SELECT password FROM user WHERE loginName='%s'", loginName));
            resultSet.next();
            password = resultSet.getString("password");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return password;
    }

    public static String getFirstNameFromBase(String loginName) {
        String firstName = "";
        try (Statement statement = getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format("SELECT firstName FROM user WHERE loginName='%s'", loginName));
            resultSet.next();
            firstName = resultSet.getString("firstName");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return firstName;
    }

    public static boolean isLoginInBase(String loginName) {
        boolean inBase = false;
        try (Statement statement = getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format("SELECT loginName FROM user WHERE loginName='%s'", loginName));
            inBase = resultSet.next();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return inBase;
    }

    public static void addPersonToBase(Person person) {
        try (Statement statement = getStatement()){
            statement.executeUpdate
                    (String.format("INSERT INTO user VALUES (NULL, '%s', '%s','%s','%s','%s','%s')",
                            person.getLogin(), person.getPassword(), person.getFirstName(), person.getLastName(),
                            person.getEmail(), person.getPhoneNumber()));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
