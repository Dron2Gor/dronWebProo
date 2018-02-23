package servlets;

import logic.ServicesForContext;
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

        if (request.getSession().getAttribute("listIdProducts") != null) {

            ArrayList<Integer> listIdProducts = (ArrayList<Integer>) request.getSession().getAttribute("listIdProducts");
            ServicesForContext.addProductsToContext(listIdProducts, page, request);


        } else {

            ServicesForContext.addProductsToContext(page, request);
        }
        ServicesForDispatcher.doDispatcherAndForward("jspS/main.jsp", request, response);
    }

}
