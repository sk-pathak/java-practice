package org.example.filters;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@WebFilter("/hello")
public class nameFilter implements jakarta.servlet.Filter {
    public void destroy(){}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest)request;
        PrintWriter out=response.getWriter();
        String username=req.getParameter("username");
        if(username.length()>5){
            chain.doFilter(req,response);
        }
        else{
            out.println("username must be of greater than 5 length");
        }
    }
    public void init(FilterConfig fConfig) throws ServletException {}
}
