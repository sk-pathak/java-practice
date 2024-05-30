package org.example.servlet_test;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/success")
public class success extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession ssn=req.getSession();
        String user= (String) ssn.getAttribute("username");
        PrintWriter out=res.getWriter();
        res.setContentType("text/html");
        out.println("<html><title>success</title><body>Successfully Logged in...Welcome "+user);
        out.println("</body></html>");
    }
}
