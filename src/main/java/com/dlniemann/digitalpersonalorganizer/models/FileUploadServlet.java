package com.dlniemann.digitalpersonalorganizer.models;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(urlPatterns = {"files/upload/uploadServlet"})
@MultipartConfig(maxFileSize = 16177215)
public class FileUploadServlet extends HttpServlet {



    private String dbURL = "jdbc:mysql://localhost:3306/digitalpersonalorganizer";
    private String dbUser = "dporganizer";
    private String dbPass = "dporganizer";

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String fileId = request.getParameter("fileId");
       String fileName = request.getParameter("fileName");
       String fileDescription = request.getParameter("fileDescription");



       InputStream inputStream = null;

       Part filePart = request.getPart("file");
       if (filePart != null) {
           System.out.println(filePart.getName());
           System.out.println(filePart.getSize());
           System.out.println(filePart.getContentType());

           inputStream = filePart.getInputStream();
       }

       Connection conn = null;
       String message = null;

       try {
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

           String sql = "INSERT INTO files (fileId, fileName, fileDescription) values (?, ?, ?)";
           PreparedStatement statement = conn.prepareStatement(sql);
           statement.setString(1, fileId);
           statement.setString(2, fileName);
           statement.setString(3, fileDescription);

           if (inputStream != null) {
               statement.setBlob(4, inputStream);
           }

        int row = statement.executeUpdate();
           if (row > 0) {
               message = "File uploaded and saved into database";
           }
       } catch (SQLException ex) {
           message = "ERROR: " + ex.getMessage();
           ex.printStackTrace();
       } finally {
           if (conn != null) {
               try {
                   conn.close();
               } catch (SQLException ex) {
                   ex.printStackTrace();
               }
           }
           request.setAttribute("Message", message);
           getServletContext().getRequestDispatcher("Files/messageUpload.html").forward(request, response);
       }


   }
}
