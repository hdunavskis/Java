package com.ait.lab3b;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfirmUserDetailsServlet", urlPatterns = "/ConfirmUserDetailsServlet")
public class ConfirmUserDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        String username = request.getParameter("username");
        String userAge = request.getParameter("userAge");
        String userSalary = request.getParameter("userSalary");

        response.setContentType("text/html");

        if (username.isEmpty() && userAge.isEmpty() && userSalary.isEmpty()) {

            printWriter.println("<html>");
            printWriter.println("<body>");
            printWriter.println("No Name specified<br>");
            printWriter.println("No Age specified <br>");
            printWriter.println("No Salary specified <br>");

            printWriter.println("</body></html>");
            printWriter.flush();
        } else {
            printWriter.println("<html>");
            printWriter.println("<body>");
            printWriter.println("Hello " + username + ".<br>" + "You are " + userAge + " old, and your salary is " +
                    userSalary + " euro.");
            printWriter.println("</body></html>");
            printWriter.flush();
        }
    }
}
