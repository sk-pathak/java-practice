package org.example.login;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.dao.LoginDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname = request.getParameter("username");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        response.setHeader("cache-control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
//        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
//        response.setHeader("Expires", "0"); //Proxies

        LoginDao dao = new LoginDao();

        try {
            if(dao.check(uname,pass)){
                session.setAttribute("uname", uname);
                session.setAttribute("pass", pass);
                out.println("<html><body>");
                out.println("<h1>Welcome "+uname+"</h1>");
                out.println("<a href='/profile'>Profile</a><br/>");
                out.println("<a href='/logout'>Logout</a>");
                out.println("</body></html>");
            }
            else{
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
