package servlets;

import beans.Product;
import logic.ModelForProduct;
import logic.ServicesForDataBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InfoAboutProduct")

public class InfoAboutProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idProduct = Integer.parseInt(req.getParameter("idProduct"));
        Product product = ServicesForDataBase.getProductFromBaseById(idProduct);
        req.setAttribute("product", product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jspS/infoAboutProduct.jsp");
        requestDispatcher.forward(req, resp);
    }
}