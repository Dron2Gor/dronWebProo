package servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type =request.getParameter("type");
        System.out.println(type);
        response.setContentType("image/jpg");
        Path paths=Paths.get("d:/wolf.jpg");
        ServletOutputStream outputStream = response.getOutputStream();
        Files.copy(paths, outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
