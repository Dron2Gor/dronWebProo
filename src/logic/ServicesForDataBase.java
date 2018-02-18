package logic;

import beans.Person;
import beans.Product;

import java.sql.*;
import java.util.ArrayList;

public class ServicesForDataBase {


    private static Connection getConnnectionDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/DronShop";
        String password = "8888";
        String userName = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
        return connection;
    }

    private static Statement getStatement() throws SQLException, ClassNotFoundException {
        Connection connection = getConnnectionDB();
        return connection.createStatement();
    }

    public static String getPasswordFromBase(String loginName) {
        String password = "";
        try {
            Statement statement = getStatement();
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
        try {
            Statement statement = getStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT firstName FROM user WHERE loginName='%s'", loginName));
            resultSet.next();
            firstName = resultSet.getString("firstName");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return firstName;
    }

    public static Product getProductFromBaseById(int id) {
        Product product = new Product();
        try {
            Statement statement = getStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM products WHERE id_product='%d'", id));
            resultSet.next();
            product.setIdProduct(resultSet.getInt("id_product"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getDouble("price"));
            product.setCount(resultSet.getInt("count"));
            product.setDescription(resultSet.getString("description"));
            product.setIdCategory(resultSet.getInt("id_category"));
            product.setImage(resultSet.getBlob("image"));

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static Blob getBlobImageFromBaseById(int id) {
        Blob blob = null;
        try {
            Statement statement = getStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT image FROM products WHERE id_product='%d'", id));
            resultSet.next();
            blob = resultSet.getBlob("image");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return blob;
    }

    public static int amountNameOfProductsInBase() {
        int amount = 0;
        try {
            Statement statement = getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(id_product) FROM products");
            resultSet.next();
            amount = resultSet.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int amountOfCategories() {
        int amount = 0;
        try {
            Statement statement = getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(id_category) FROM categories");
            resultSet.next();
            amount = resultSet.getInt(1);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static ArrayList<Integer> getIdProductFromBaseByNameCategory(String nameCategory){
         ArrayList<Integer> ids=new ArrayList<>();

        try (Statement statement = getStatement()) {
            ResultSet resultSet=statement.executeQuery(String.format(
                    "SELECT id_product FROM products, categories WHERE nameCategory='%s' " +
                            "AND products.id_category=categories.id_category", nameCategory));
            while (resultSet.next()){
                ids.add(resultSet.getInt("id_product"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  ids;
    }
    public static String getNameCategoryFromCategoriesById(int id) {
        String nameCategory = null;
        try (Statement statement = getStatement()) {
            ResultSet resultSet = statement.executeQuery(String.format
                    ("SELECT nameCategory FROM categories WHERE id_category='%d'", id));
            resultSet.next();
            nameCategory = resultSet.getString("nameCategory");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return nameCategory;
    }

    public static ArrayList<String> getAllCategoryNamesFromCategories() {
        ArrayList<String> namesCategory = new ArrayList<>();
        try (Statement statement = getStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT nameCategory FROM categories");
            while (resultSet.next()) {
                namesCategory.add(resultSet.getString("nameCategory"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return namesCategory;
    }

    public static boolean isLoginInBase(String loginName) {
        boolean inBase = false;
        try {
            Statement statement = getStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT loginName FROM user WHERE loginName='%s'", loginName));
            inBase = resultSet.next();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return inBase;
    }

    public static void addPersonToBase(Person person) {
        try {
            Statement statement = getStatement();
            statement.executeUpdate
                    (String.format("INSERT INTO user VALUES (NULL, '%s', '%s','%s','%s','%s','%s')",
                            person.getLogin(), person.getPassword(), person.getFirstName(), person.getLastName(),
                            person.getEmail(), person.getPhoneNumber()));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addProductToBase(Product product) {
        try {
            Statement statement = getStatement();
            statement.executeUpdate
                    (String.format("INSERT INTO user VALUES (NULL, '%s', '%s','%s','%s','%s','%s')", product.getName(),
                            product.getPrice(), product.getCount(), product.getDescription(), product.getIdCategory()));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getIdProductFromBaseByNameCategory("Modem"));

    }
}
