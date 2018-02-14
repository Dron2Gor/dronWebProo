package logic;

import beans.Person;

import java.sql.*;

public class ServicesForDataBase {
    private static String userName = "root";
    private static String password = "8888";
    private static String connectionUrl = "jdbc:mysql://localhost:3306/DronShop";


    public static Connection getConnnectionDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
        return connection;
    }

    public static String getPasswordFromBase(String loginName) {
        String password = "";
        try {
            Connection connection = getConnnectionDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT password FROM user WHERE loginName='" + loginName + "'");
            resultSet.next();
            password = resultSet.getString("password");

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return password;
    }
    public static String getFirstNameFromBase(String loginName) {
        String firstName = "";
        try {
            Connection connection = getConnnectionDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT firstName FROM user WHERE loginName='" + loginName + "'");
            resultSet.next();
            firstName = resultSet.getString("firstName");

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return firstName;
    }

    public static boolean isLoginInBase(String loginName) {
        boolean inBase = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {

            connection = getConnnectionDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT loginName FROM user WHERE loginName='" + loginName + "'");
            inBase = resultSet.next();

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inBase;
    }

    public static void addPersonToBase(Person person) {
        try {
            Connection connection = getConnnectionDB();
            Statement statement = connection.createStatement();
            statement.executeUpdate
                    ("INSERT INTO user VALUES (NULL, '" + person.getLogin() + "', '" + person.getPassword() + "','" + person.getFirstName() + "','" +
                            "" + person.getLastName() + "','" + person.getEmail() + "','" + person.getPhoneNumber() + "')");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Connection connection = getConnnectionDB();
//        Statement statement = connection.createStatement();
////        statement.executeUpdate("INSERT INTO user VALUES (NULL, 'Oles', '4444', 'Olesya','Samuseva','olesya@olesy.com', '66-66-66')");
//        String st = "Dron";
//        ResultSet resultSet = statement.executeQuery("SELECT loginName FROM user WHERE loginName='" + st + "' ");
//        boolean next = resultSet.next();
//        if (!next) {
//            System.out.println("ops");
//        } else System.out.println("Yea");
//        resultSet.close();
//        statement.close();
//        connection.close();
        System.out.println(getPasswordFromBase("Oles"));
    }
}
