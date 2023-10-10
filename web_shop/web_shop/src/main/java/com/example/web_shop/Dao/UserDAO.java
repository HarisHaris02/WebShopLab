package com.example.web_shop.Dao;

import com.example.web_shop.EntitiesInfo.UserInfo;
import com.example.web_shop.Handlers.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends User {
    private final static String url = "jdbc:mysql://127.0.0.1:3306/workshop";
    private final static String username = "root";
    private final static String password = "123456_S";
    public UserDAO(int id, String username, String email, String card, String password) {
        super(id, username, email, card, password);
    }

    public UserDAO() {
    }

    public static User getUserByEmail(String email) {
        User user = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                UserDAO newUserDao = new UserDAO(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("card"));

                user = newUserDao;
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public static boolean registerUsers(UserDAO user) {
        boolean isRegistered = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO users (username, email, password, card) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getCard());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                isRegistered = true;
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isRegistered;
    }
}