package logic;

import beans.Product;

import java.util.ArrayList;

public class ModelForProduct {
    private ArrayList<Product> listOfProducts = new ArrayList<>();

    public ModelForProduct(int page) {
        makeListOfProducts(page);
    }
    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    private void makeListOfProducts(int page) {
        int amount=page;
        int step =1;
        for (int i = amount; i < amount+step; i++) {
            listOfProducts.add(ServicesForDataBase.getProductFromBaseById(i));
        }
    }

    public Product getProduct(int id) {
        return listOfProducts.get(id);
    }

    public static void main(String[] args) {
        ModelForProduct modelForProduct = new ModelForProduct(1);
        Product product = modelForProduct.getProduct(1);
        System.out.println(product.getName());
    }

}
