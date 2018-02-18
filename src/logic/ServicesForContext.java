package logic;

import beans.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ServicesForContext {

    public static void addProductsToContext(int page, HttpServletRequest request){

        ModelForProduct model=new ModelForProduct(page);

        ArrayList<Product> products =model.getListOfProducts();
        request.getServletContext().setAttribute("products", products);

    }
}
