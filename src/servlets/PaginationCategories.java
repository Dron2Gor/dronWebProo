package servlets;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameCategory=request.getParameter("nameCategory");

        ArrayList<Integer> listIdProducts= ServicesForDataBase.getListIdProductFromBaseByNameCategory(nameCategory);
        request.getServletContext().setAttribute("listIdProducts",listIdProducts);

        ServicesForDispatcher.doDispatcherAndForward("jspS/main.jsp",request,response);
    }
}
