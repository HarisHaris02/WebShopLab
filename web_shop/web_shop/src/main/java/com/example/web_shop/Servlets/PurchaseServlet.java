package com.example.web_shop.Servlets;

import com.example.web_shop.Dao.ShoppingCartDAO;
import com.example.web_shop.EntitiesInfo.UserInfo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PurchaseServlet", value = "/buy")
public class PurchaseServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("user");

        if (userInfo != null) {
            // Remove clearCart method call
            response.sendRedirect("confirm.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}