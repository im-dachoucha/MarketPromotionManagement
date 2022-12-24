package com.example.marketpromotionmanagement.Servlets.DepartmentManager;

import com.example.marketpromotionmanagement.Controllers.DepartmentManagerController;
import com.example.marketpromotionmanagement.Controllers.StoreAdminController;
import com.example.marketpromotionmanagement.entities.Departmentmanager;
import com.example.marketpromotionmanagement.entities.Storeadmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet({"/department-manager/login", "/department-manager/logout"})
public class DptManagerLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("login_error", false);
        request.getRequestDispatcher("/DptManager/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        switch(url){
            case "/department-manager/login":
                login(request, response);
                break;
            case "/department-manager/logout":
                logout(request, response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Departmentmanager departmentmanager = DepartmentManagerController.login(email, password);
        if(departmentmanager == null){
            request.setAttribute("login_error", true);
            request.getRequestDispatcher("/DptManager/Login.jsp").forward(request, response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("dpt_manager", departmentmanager);

            request.setAttribute("login_error", false);

            response.sendRedirect(request.getContextPath()+"/department-manager/promotions");
        }
    }
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("dpt_manager");

        response.sendRedirect(request.getContextPath()+"/department-manager/login");
    }
}
