package com.example.web_shop.Handlers;

import com.example.web_shop.Dao.UserDAO;
import com.example.web_shop.EntitiesInfo.UserInfo;

public class UserHandler {



    public UserHandler() {

    }

    public static UserInfo getUserByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }

        User user = User.getUserByEmail(email);
        if (user == null) {
            return null;
        }
        return new UserInfo(user.getId(), user.getUsername(), user.getEmail(), user.getCard(), user.getPassword());
    }

    public static boolean registerUser(UserInfo user) {
        System.out.println("USER: " + user.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty() ||
                user.getPassword() == null || user.getPassword().isEmpty() ||
                user.getUsername() == null || user.getUsername().isEmpty() ||
                user.getCard() == null || user.getCard().isEmpty()) {
            throw new IllegalArgumentException("User's email, password, username, and card cannot be null or empty.");
        }

        return User.registerUser(new User(user.getId(), user.getUsername(), user.getEmail(), user.getCard(), user.getPassword()));
    }
}