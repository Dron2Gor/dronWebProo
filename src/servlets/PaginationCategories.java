package servlets;

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

@WebServlet("/PaginationCategories")
public class PaginationCategories extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameCategory = request.getParameter("nameCategory");

        if (nameCategory.equals("all")) {
            request.getSession().removeAttribute("listIdProducts");
            ServicesForContext.addProductsToContext(1,request);
        } else {
            ArrayList<Integer> listIdProducts = ServicesForDataBase.getListIdProductFromBaseByNameCategory(nameCategory);
            request.getSession().setAttribute("listIdProducts", listIdProducts);

            if (listIdProducts!=null & !listIdProducts.isEmpty()) ServicesForContext.addProductsToContext(listIdProducts, 1, request);
            else request.getServletContext().setAttribute("products",null);
        }
        ServicesForDispatcher.doDispatcherAndForward("jspS/main.jsp", request, response);
    }
}
