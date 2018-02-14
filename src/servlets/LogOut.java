package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LogOut")
public class LogOut extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
             cookie.setMaxAge(0);
             response.addCookie(cookie);
        }
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("jspS/main.jsp");
        requestDispatcher.forward(request,response);
    }
}
