package logic;

import beans.Product;

import java.util.ArrayList;

public class ModelForProduct {
    ArrayList<Product> listOfProducts = new ArrayList<>();

    public ModelForProduct() {
        makeListOfProducts();
    }

    public int size(){
        return listOfProducts.size();
    }

    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    private void makeListOfProducts() {
        Product product1 = new Product();
        product1.setName("PRODUCT #1");
        product1.setDescription("This is test good. It is very very kind!!!");
        product1.setPrice(88.44);
        product1.setCount(6);
        product1.setIdProduct(0);

        Product product2 = new Product();
        product2.setName("PRODUCT #2");
        product2.setDescription("This is good #2. It is not very kind!!!");
        product2.setPrice(22.22);
        product2.setCount(4);
        product2.setIdProduct(1);
        listOfProducts.add(product1);
        listOfProducts.add(product2);

    }

    public Product getProduct(int id) {
        return listOfProducts.get(id);
    }

    public static void main(String[] args) {
        ModelForProduct modelForProduct = new ModelForProduct();
        Product product = modelForProduct.getProduct(0);
        System.out.println(product.getName());
    }

}
