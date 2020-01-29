package com.ait.lab3c;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "CustomerDetails", urlPatterns = "/CustomerDetails")
public class CustomerDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String url;
    private String driver = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            url = "jdbc:mysql://localhost:3306/tech_support?user=helmuts@localhost&password=root";
            driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url);

            String sql = "SELECT * FROM customers ORDER BY firstName";
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<table><tr><td>First Name</td><td>Last Name</td><td>Email Address</td></tr>");
            while (resultset.next()) {
                out.println("<tr><td>" + resultset.getString("firstName")
                        + "</td><td>" + resultset.getString("lastName")
                        + "</td><td>" + resultset.getString("email") + "</td></tr>");
            }
            out.println("</table>");
            // Clean-up environment
            resultset.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}

