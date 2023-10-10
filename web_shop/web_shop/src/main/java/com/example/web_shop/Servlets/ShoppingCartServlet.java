package com.example.web_shop.Servlets;

import com.example.web_shop.EntitiesInfo.UserInfo;
import com.example.web_shop.Handlers.ProductHandler;
import com.example.web_shop.Handlers.ShoppingCartHandler;
import com.example.web_shop.EntitiesInfo.ProductInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ShoppingCartServlet", value = "/ShoppingCart")
public class ShoppingCartServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productIdStr = request.getParameter("productId");
        int productId = Integer.parseInt(productIdStr);

        ProductInfo product;
        product = ProductHandler.getProductById(productId);

        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");

        if (user != null && product != null) {
            try {
                ShoppingCartHandler.addToCart(productId, user.getId(), 1);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("index.jsp");

        } else {
            response.sendRedirect("login.jsp");
        }
    }
}