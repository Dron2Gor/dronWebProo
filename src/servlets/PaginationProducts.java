package servlets;

import beans.Product;
import logic.ServicesForContext;
import logic.ServicesForDataBase;
import logic.ServicesForDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/PaginationProducts")
public class PaginationProducts extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int step = 1;

        if (request.getServletContext().getAttribute("listIdProducts") != null) {
            ArrayList<Product> products = new ArrayList<Product>();
            ArrayList<Integer> listIdProducts = (ArrayList<Integer>) request.getServletContext().getAttribute("listIdProducts");
            for (int i = page * step - step + 1; i <= page * step; i++) {
                Product product = ServicesForDataBase.getProductFromBaseById(listIdProducts.get(i - 1));
                products.add(product);
                request.getServletContext().setAttribute("products", products);
            }

        } else {
            ServicesForContext.addProductsToContext(page, request);
        }
        ServicesForDispatcher.doDispatcherAndForward("jspS/main.jsp", request, response);
    }

}
