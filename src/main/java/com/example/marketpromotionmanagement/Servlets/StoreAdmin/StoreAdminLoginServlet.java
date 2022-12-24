package com.example.marketpromotionmanagement.Servlets.StoreAdmin;

import com.example.marketpromotionmanagement.Controllers.StoreAdminController;
import com.example.marketpromotionmanagement.entities.Storeadmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet({"/store-admin/login", "/store-admin/logout"})
public class StoreAdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("login_error", false);
        request.getRequestDispatcher("/StoreAdmin/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        switch (url) {
            case "/store-admin/login":
                login(request, response);
                break;
            case "/store-admin/logout":
                logout(request, response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Storeadmin storeadmin = StoreAdminController.login(email, password);
        if (storeadmin == null) {
            request.setAttribute("login_error", true);
            request.getRequestDispatcher("/StoreAdmin/Login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("store_admin", storeadmin);

            request.setAttribute("login_error", false);
            request.setAttribute("store_admin", storeadmin);

            response.sendRedirect(request.getContextPath() + "/store-admin/promotions");
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("store_admin");

        response.sendRedirect(request.getContextPath() + "/store-admin/login");
    }
}
