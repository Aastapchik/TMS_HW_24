package com.teachMeSkills.task.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/load-book")
public class FilterServlet implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter printWriter = servletResponse.getWriter();
        String id = servletRequest.getParameter("id");
        if(Integer.parseInt(id) <= 0 || id == null) {
            printWriter.write("ID " + id + " incorrect!!");
        } else filterChain.doFilter(servletRequest, servletResponse);

    }
}
