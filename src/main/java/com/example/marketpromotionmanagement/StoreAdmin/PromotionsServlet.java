package com.example.marketpromotionmanagement.StoreAdmin;

import com.example.marketpromotionmanagement.Controllers.PromotionController;
import com.example.marketpromotionmanagement.entities.Promotion;
import com.example.marketpromotionmanagement.entities.Storeadmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet({"/store-admin/promotions", "/store-admin/delete-promotion"})
public class PromotionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Storeadmin storeadmin = (Storeadmin) session.getAttribute("Store_admin");
        List<Promotion> promotions = PromotionController.getPromotionsForStoreAdmin(storeadmin);
        request.setAttribute("promotions", promotions);

        request.getRequestDispatcher(request.getContextPath()+"/StoreAdmin/Promotions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath() != null ? request.getServletPath() : "";
        switch (path) {
            case "/store-admin/promotions":
                savePromotions(request, response);
                break;
            case "/store-admin/delete-promotion":
                deletePromotion(request, response);
                break;
        }
    }

    private void deletePromotion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean ok = PromotionController.deletePromotionById(Integer.valueOf(request.getParameter("promoId")));
        System.out.println(request.getParameter("promoId"));
        System.out.println(ok);
        if(!ok)
            request.setAttribute("promotion_error", true);
        response.sendRedirect(request.getContextPath()+"/store-admin/promotions");
    }

    private void savePromotions(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String description = request.getParameter("description");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        BigDecimal discount = BigDecimal.valueOf(Double.parseDouble(request.getParameter("discount")));
        Integer subDptId = Integer.parseInt(request.getParameter("subDepartment"));
        Integer storeId = ((Storeadmin) session.getAttribute("Store_admin")).getStoreid();
        Promotion promotion = PromotionController.save(description, startDate, endDate, discount, subDptId, storeId);
        if (promotion == null || promotion.getId() == null)
            request.setAttribute("promotion_error", true);

        response.sendRedirect(request.getContextPath()+"/store-admin/promotions");
    }
}
