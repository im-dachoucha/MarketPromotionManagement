package com.example.marketpromotionmanagement.StoreAdmin;

import Controllers.PromotionController;
import Controllers.StoreAdminController;
import entities.Promotion;
import entities.Storeadmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/store-admin-login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("login_error", false);
        request.getRequestDispatcher("StoreAdmin/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Storeadmin storeadmin = StoreAdminController.login(email, password);
        if(storeadmin == null){
            request.setAttribute("login_error", true);
            request.getRequestDispatcher("StoreAdmin/Login.jsp").forward(request, response);
        }else{
            List<Promotion> promotions = PromotionController.getPromotionsForStoreAdmin(storeadmin);

            HttpSession session = request.getSession();
            session.setAttribute("Store_admin", storeadmin);
            session.setAttribute("promotions", promotions);

            request.setAttribute("login_error", false);
            request.setAttribute("store_admin", storeadmin);
            request.getRequestDispatcher("StoreAdmin/Dashboard.jsp").forward(request, response);
        }
    }
}
