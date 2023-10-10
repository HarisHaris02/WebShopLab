package com.example.web_shop.Servlets;

import com.example.web_shop.Handlers.ProductHandler;
import com.example.web_shop.Handlers.ShoppingCartHandler;
import com.example.web_shop.EntitiesInfo.ProductInfo;
import com.example.web_shop.Handlers.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ShoppingCartServlet", value = "/ShoppingCart")
public class ShoppingCart extends HttpServlet {

    private ShoppingCartHandler shoppingCartHandler;

    @Override
    public void init() {
        shoppingCartHandler = new ShoppingCartHandler();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productIdStr = request.getParameter("productId");
        int productId = Integer.parseInt(productIdStr);
        ProductInfo product;
        product = ProductHandler.getProductById(productId);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("user: " + user);
        System.out.println("product: " + product);
        if (user != null && product != null) {
            try {
                shoppingCartHandler.addToCart(productId, user.getId(), 1);
                response.sendRedirect("index.jsp");
            } catch (SQLException e) {
                throw new ServletException("Cannot add product to cart", e);
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}