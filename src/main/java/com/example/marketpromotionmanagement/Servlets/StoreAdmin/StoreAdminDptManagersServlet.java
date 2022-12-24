package com.example.marketpromotionmanagement.Servlets.StoreAdmin;

import com.example.marketpromotionmanagement.Controllers.DepartmentManagerController;
import com.example.marketpromotionmanagement.Dao.DepartmentDao;
import com.example.marketpromotionmanagement.entities.Department;
import com.example.marketpromotionmanagement.entities.Departmentmanager;
import com.example.marketpromotionmanagement.entities.Storeadmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet({"/store-admin/managers", "/store-admin/delete-manager"})
public class StoreAdminDptManagersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Storeadmin storeadmin = (Storeadmin) session.getAttribute("store_admin");

        List<Departmentmanager> dptManagers = DepartmentManagerController.getStoreDptManagers(storeadmin.getStoreid());
        session.setAttribute("managers", dptManagers);

        List<Department> departments = new DepartmentDao().getAll();
        session.setAttribute("departments", departments);

        request.getRequestDispatcher("/StoreAdmin/Managers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath() != null ? request.getServletPath() : "";
        switch (path) {
            case "/store-admin/managers":
                saveManager(request, response);
                break;
            case "/store-admin/delete-manager":
                deleteManager(request, response);
                break;
        }
    }

    private static void saveManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Integer dptId = Integer.valueOf(request.getParameter("department"));

        HttpSession session = request.getSession();
        Storeadmin storeadmin = (Storeadmin) session.getAttribute("store_admin");

        Departmentmanager departmentmanager = DepartmentManagerController.save(email, password, dptId, storeadmin.getStoreid());
        if (departmentmanager == null || departmentmanager.getId() == null)
            session.setAttribute("manager_error", true);

        response.sendRedirect(request.getContextPath() + "/store-admin/managers");
    }

    private static void deleteManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/store-admin/managers");
    }
}
