package com.example.web_shop.Servlets;

import java.io.IOException;

import com.example.web_shop.EntitiesInfo.UserInfo;
import com.example.web_shop.Handlers.UserHandler;
import com.example.web_shop.Encoders.PasswordEncoder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserHandler userHandler = new UserHandler();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String cardNumber = request.getParameter("cardNumber");

        if(userHandler.getUserByEmail(email) != null) {
            request.setAttribute("errorMessage", "Email already registered. Please login.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }

        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match. Please try again.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(name);
        userInfo.setEmail(email);
        userInfo.setPassword(PasswordEncoder.hashPassword(password));
        userInfo.setCard(cardNumber);
        System.out.println(userInfo.getUsername());
        if (userHandler.registerUser(userInfo)) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", "User registration failed. Please try again.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }
}