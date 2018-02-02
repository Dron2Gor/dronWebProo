package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    static String st;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter=resp.getWriter();
        printWriter.write("Dron First Servlet");
         st=req.getParameter("one");
        if (st!=null)
        printWriter.write(" "+st);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parametr=req.getParameter("button");
        PrintWriter printWriter=resp.getWriter();
        printWriter.write("Dron + ");
        printWriter.write(parametr);
//        req.getRequestDispatcher("WEB/")
    }
}
