package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static logic.ServicesForDispatcher.doDispatch;

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
        doDispatch("jspS/main.jsp", request, response);
    }
}
