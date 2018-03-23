package logic.servicesForDataBase;

import beans.Order;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ServicesForOrderDB extends ServicesForDataBase {

    public static int getIdOrderForNewOrderFromBase() {
        int id = 0;
        try (Statement statement = getStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT max(id_order) AS max FROM orders");
            while (resultSet.next()) {
                id = resultSet.getInt("max");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int addOrderToBase(Order order) {

        java.sql.Date sqlData= new java.sql.Date(new Date().getTime());
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String date = format.format(new Date());

        try (PreparedStatement preparedStatement = getConnnectionDB().prepareStatement("INSERT  INTO orders (id_user, date, address) " +
                "VALUES (?, ?,?)")) {
        preparedStatement.setInt(1,order.getIdUser());
        preparedStatement.setObject(2, date);
        preparedStatement.setString(3, order.getAddress());
        preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try (Statement statement = getStatement()) {
//
//            statement.executeUpdate(String.format("INSERT INTO orders VALUES (NULL, '%d', '%d', '%s')",
//                    order.getIdUser(),sqlData.getTime(), order.getAddress()));
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        return  addBasketToBase(order.getBasket());

    }

    private static int addBasketToBase(HashMap<Integer, Integer> map) {

        int idOrder = ServicesForOrderDB.getIdOrderForNewOrderFromBase();

        try (Statement statement = getStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT max(id_order) AS max FROM orders");
            while (resultSet.next()) {
                idOrder = resultSet.getInt("max");
            }
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                statement.executeUpdate(String.format("INSERT INTO baskets VALUES (NULL ,'%d','%d','%d')",
                        idOrder, pair.getKey(), pair.getValue()));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return idOrder;
    }

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date=new Date();

//        java.sql.Timestamp sqlData= new java.sql.Timestamp(new Date().getTime());
//        long time = sqlData.getTime();
//        String.format("Time '%d'",time);
//        System.out.println(sqlData);
//        System.out.println(new Date().getTime());
    }
}
