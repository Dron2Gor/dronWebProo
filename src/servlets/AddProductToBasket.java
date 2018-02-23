package servlets;

import beans.Basket;
import logic.ServicesForDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/AddProductToBasket")
public class AddProductToBasket extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        Basket basket= new Basket();
        if (request.getSession().getAttribute("basket")!=null){
            basket=(Basket) request.getSession().getAttribute("basket");
        }
        basket.addProductToBasket(idProduct);
        request.getSession().setAttribute("basket", basket);
        ServicesForDispatcher.doDispatcherAndForward("jspS/main.jsp",request,response);
    }
}