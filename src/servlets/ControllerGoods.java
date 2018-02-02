package servlets;

import beans.Good;
import logic.ModelForGood;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/good")
public class ControllerGoods extends HttpServlet{
        ModelForGood model=new ModelForGood();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//            Good good=model.getGood(i);
//            req.setAttribute("good",good);
        ArrayList<Good> goods=model.getListOfGoods();
        req.setAttribute("goods",goods);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
