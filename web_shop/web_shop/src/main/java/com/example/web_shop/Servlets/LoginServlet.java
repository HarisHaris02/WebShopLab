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
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserHandler userHandler;

    public void init() {
        this.userHandler = new UserHandler();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = PasswordEncoder.hashPassword(request.getParameter("password"));

        UserInfo userInfo = userHandler.getUserByEmail(email);
        System.out.println("USERINFO" + userInfo.getEmail() + " " + userInfo.getPassword() + " " + userInfo.getCard());
        System.out.println("PASS: " + password);
        if (userInfo != null && userInfo.getPassword().equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", userInfo);
            session.setAttribute("name", userInfo.getUsername());
            response.sendRedirect("index.jsp");
        } else {

            request.setAttribute("errorMessage", "Invalid email or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}