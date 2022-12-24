package com.example.marketpromotionmanagement.Servlets.DepartmentManager;

import com.example.marketpromotionmanagement.Controllers.PromotionController;
import com.example.marketpromotionmanagement.entities.Departmentmanager;
import com.example.marketpromotionmanagement.entities.Promotion;
import com.example.marketpromotionmanagement.entities.Storeadmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet({"/department-manager/promotions", "/department-manager/refuse-promotion", "/department-manager/accept-promotion"})
public class DptManagerPromotionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Departmentmanager departmentmanager = (Departmentmanager) session.getAttribute("dpt_manager");
        List<Promotion> promotions = PromotionController.getPromotionsForDptManager(departmentmanager);
        request.setAttribute("promotions", promotions);

        request.getRequestDispatcher("/DptManager/Promotions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/department-manager/refuse-promotion":
                refusePromotion(request, response);
                break;
            case "/department-manager/accept-promotion":
                acceptPromotion(request, response);
                break;
        }
        response.sendRedirect(request.getContextPath() + "/department-manager/promotions");
    }

    private void refusePromotion(HttpServletRequest request, HttpServletResponse response) {
        Integer promotionId = Integer.parseInt(request.getParameter("promoId"));
        System.out.println(promotionId);
        PromotionController.refuse(promotionId);
    }
    private void acceptPromotion(HttpServletRequest request, HttpServletResponse response) {
        Integer promotionId = Integer.parseInt(request.getParameter("promoId"));
        PromotionController.accept(promotionId);
    }


}
