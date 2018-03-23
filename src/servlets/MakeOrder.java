package servlets;

import beans.Basket;
import beans.Order;
import logic.ServicesForDispatcher;
import logic.ServicesForSession;
import logic.servicesForDataBase.ServicesForOrderDB;
import logic.servicesForDataBase.ServicesForUserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@WebServlet("/MakeOrder")
public class MakeOrder extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = "";
        String address = request.getParameter("address");


        if (address == null | address.equals("")) {
            error = "Address can not be empty.";
        } else {

            String loginName = ServicesForSession.getLoginNameFromSession(request);
            Order order = new Order();
            order.setIdUser(ServicesForUserDB.getIdUserFromBaseByLogin(loginName));
            order.setAddress(address);
            order.setDate(new Date());
            Basket basket = ServicesForSession.getBasketFromSesion(request);
            order.setBasket(basket.getBasket());

            int idOrder = ServicesForOrderDB.addOrderToBase(order);

            request.setAttribute("idOrder", String.valueOf(idOrder));
            request.getSession().setAttribute("basket", null);
        }
        if (error.equals("")) {

            ServicesForDispatcher.doDispatcherAndForward("jspS/successfulOrder.jsp", request, response);
        }
        else {
            request.setAttribute("error", error);
            ServicesForDispatcher.doDispatcherAndForward("jspS/viewBasket.jsp", request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
