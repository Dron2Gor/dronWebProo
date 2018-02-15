package servlets;

import beans.Product;
import logic.ModelForProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/product")
public class ControllerProducts extends HttpServlet{
        ModelForProduct model=new ModelForProduct();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Product> products =model.getListOfProducts();
        req.getServletContext().setAttribute("products", products);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("jspS/main.jsp");
            requestDispatcher.forward(req,resp);
    }
}
