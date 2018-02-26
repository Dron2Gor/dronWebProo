package logic;

import beans.Product;
import logic.servicesForDataBase.ServicesForProductDB;

import java.util.ArrayList;

public class ModelForProduct {

    private ArrayList<Product> listOfProducts = new ArrayList<>();
    private int step = ServicesForPages.getStep();

    public ModelForProduct(int page) {
        makeListOfProducts(page);
    }


    public ModelForProduct(ArrayList<Integer> list, int page) {
        makeListOfProducts(list, page);
    }

    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    private void makeListOfProducts(int page) {

        for (int i = page * step - step + 1; i <= page * step; i++) {
            listOfProducts.add(ServicesForProductDB.getProductFromBaseById(i));
        }
    }

    private void makeListOfProducts(ArrayList<Integer> listIdProducts, int page) {
        int end = page * step;
        if (end >= listIdProducts.size()) end = listIdProducts.size();
        for (int i = page * step - step + 1; i <= end; i++) {
            Product product = ServicesForProductDB.getProductFromBaseById(listIdProducts.get(i - 1));
            listOfProducts.add(product);
        }
    }
}
