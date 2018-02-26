package logic.servicesForDataBase;

import java.sql.*;

public class ServicesForDataBase {

    private static Connection getConnnectionDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/DronShop";
        String password = "8888";
        String userName = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
        return connection;
    }
    static Statement getStatement() throws SQLException, ClassNotFoundException {
        Connection connection = getConnnectionDB();
        return connection.createStatement();
    }

    public static Blob getBlobImageFromBaseById(int id) {
        Blob blob = null;
        try (Statement statement = getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format("SELECT image FROM products WHERE id_product='%d'", id));
            while (resultSet.next())
                blob = resultSet.getBlob("image");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return blob;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        System.out.println(getListIdProductFromBaseByNameCategory("Modem"));

    }
}
