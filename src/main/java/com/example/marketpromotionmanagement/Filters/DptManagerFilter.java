package com.example.marketpromotionmanagement.Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/department-manager/*"})
public class DptManagerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        String url = ((HttpServletRequest) request).getServletPath();
        if (url.equals("/department-manager/login")) {
            chain.doFilter(request, response);
        } else {
            if (session.getAttribute("dpt_manager") == null)
                ((HttpServletResponse) response).sendRedirect("/department-manager/login");
            else
                chain.doFilter(request, response);
        }
    }
}
