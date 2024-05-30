package org.example.servlet_test;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/login")
public class login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        String username=req.getParameter("username");
        String password=req.getParameter("pass");
        if(Objects.equals(username, "skpathak") && Objects.equals(password, "19209449")){
            HttpSession ssn=req.getSession();
            ssn.setAttribute("username",username);
            ssn.setAttribute("pass",password);
            res.sendRedirect("success");
        }
        else{
            PrintWriter out = res.getWriter();
            out.println("<html><title>Failed</title><body>");
            out.println("Wrong credentials!!!");
            out.println("</body></html>");
        }
    }
}
