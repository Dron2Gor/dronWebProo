package logic.servicesForDataBase;

import beans.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServicesForProductDB extends ServicesForDataBase {

    public static Product getProductFromBaseById(int id) {
        Product product = new Product();
        try (Statement statement = getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM products WHERE id_product='%d'", id));
            while (resultSet.next()) {
                product.setIdProduct(resultSet.getInt("id_product"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setCount(resultSet.getInt("count"));
                product.setDescription(resultSet.getString("description"));
                product.setIdCategory(resultSet.getInt("id_category"));
                product.setImage(resultSet.getBlob("image"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static int amountNameOfProductsInBase() {
        int amount = 0;
        try (Statement statement = getStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT count(id_product) FROM products");
            resultSet.next();
            amount = resultSet.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static void addProductToBase(Product product) {
        try (Statement statement = getStatement()){
            statement.executeUpdate
                    (String.format("INSERT INTO user VALUES (NULL, '%s', '%s','%s','%s','%s')", product.getName(),
                            product.getPrice(), product.getCount(), product.getDescription(), product.getIdCategory()));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static int amountOfCategories() {
        int amount = 0;
        try (Statement statement = getStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT count(id_category) FROM categories");
            resultSet.next();
            amount = resultSet.getInt(1);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static ArrayList<Integer> getListIdProductFromBaseByNameCategory(String nameCategory){
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
}
