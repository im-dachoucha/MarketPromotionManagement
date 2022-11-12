package com.example.marketpromotionmanagement.StoreAdmin;

import com.example.marketpromotionmanagement.Controllers.StoreAdminController;
import com.example.marketpromotionmanagement.entities.Storeadmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/store-admin/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("login_error", false);
        request.getRequestDispatcher(request.getContextPath() + "/StoreAdmin/Login.jsp").forward(request, response);
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
            HttpSession session = request.getSession();
            session.setAttribute("Store_admin", storeadmin);

            request.setAttribute("login_error", false);
            request.setAttribute("store_admin", storeadmin);

            response.sendRedirect(request.getContextPath()+"/store-admin/promotions");
        }
    }
}
