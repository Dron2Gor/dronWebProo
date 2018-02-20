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

    private void makeListOfProducts(ArrayList<Integer> list) {

    }

    private void makeListOfProducts(int page) {
        int step =1;
        for (int i = page*step-step+1; i <= page*step; i++) {
            listOfProducts.add(ServicesForDataBase.getProductFromBaseById(i));
        }
    }


    public static void main(String[] args) {

    }

}
