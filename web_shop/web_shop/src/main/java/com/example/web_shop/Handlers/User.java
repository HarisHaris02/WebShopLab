package com.example.web_shop.Handlers;

import com.example.web_shop.Dao.UserDAO;
import com.example.web_shop.EntitiesInfo.UserInfo;

public class User {
    private int id;
    private String username;
    private String email;
    private String card;
    private String password;

    public User() {
    }

    protected User(int id, String username, String email, String card, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.card = card;
    }
    protected static User getUserByEmail(String email) {
        return UserDAO.getUserByEmail(email);
    }
    public static boolean registerUser(User user) {

        return UserDAO.registerUsers(new UserDAO(user.getId(), user.getUsername(), user.getEmail(), user.getCard(), user.getPassword()));
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
