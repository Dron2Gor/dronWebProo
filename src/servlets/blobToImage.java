package servlets;

import logic.ServicesForDataBase;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet("/blobToImage")
public class blobToImage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("image/jpg");

        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        Blob blob = ServicesForDataBase.getBlobImageFromBaseById(idProduct);

        OutputStream outputStream = response.getOutputStream();
        byte[] b = null;
        try {
            b = blob.getBytes(1, (int) blob.length());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        outputStream.write(b);


    }
}
