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

@WebServlet("/info")
public class Info extends HttpServlet {
    ModelForGood model=new ModelForGood();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int articul=Integer.parseInt(req.getParameter("info"));
        Good good=model.getGood(articul);
        System.out.println(good.getName());
        req.setAttribute("good",good);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/jspS/info.jsp");
        requestDispatcher.forward(req,resp);
    }
}
