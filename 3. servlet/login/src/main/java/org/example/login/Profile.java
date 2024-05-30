package org.example.login;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profile")
public class Profile extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();

        res.setHeader("cache-control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
//        res.setHeader("Pragma", "no-cache"); //HTTP 1.0
//        res.setHeader("Expires", "0"); //Proxies

        if(session.getAttribute("uname")==null){
            res.sendRedirect("index.jsp");
        }
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<a href='/logout'>Logout</a>");
        out.println("</body></html>");
    }
}
