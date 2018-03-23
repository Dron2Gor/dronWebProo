package servlets;

import beans.Basket;
import logic.ServicesForDispatcher;
import logic.ServicesForSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MinusProduct")
public class MinusProduct extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        Basket basket = ServicesForSession.getBasketFromSesion(request);
        basket.removeOneProductFromBasket(idProduct);
        request.getSession().setAttribute("basket", basket);
        if (basket.getBasket().isEmpty()) {
            ServicesForDispatcher.doDispatcherAndForward("jspS/main.jsp", request, response);
        } else
            ServicesForDispatcher.doDispatcherAndForward("jspS/viewBasket.jsp", request, response);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
