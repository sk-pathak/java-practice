package org.example.filters;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@WebFilter("/hello")
public class idFilter implements jakarta.servlet.Filter {
    public void destroy(){}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        if(id>0) chain.doFilter(req,response);
        else{
            out.println("id must be greater than 0");
        }
    }
    public void init(FilterConfig fConfig) throws ServletException {}
}
