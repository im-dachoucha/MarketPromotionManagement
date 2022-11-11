import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/store-admin/promotions", "/store-admin/delete-promotion"})
public class StoreAdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        if (session.getAttribute("Store_admin") == null)
            ((HttpServletResponse) response).sendRedirect("/store-admin-login");
        else
            chain.doFilter(request, response);
    }
}
