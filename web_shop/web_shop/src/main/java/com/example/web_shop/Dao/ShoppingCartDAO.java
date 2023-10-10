package com.example.web_shop.Dao;

import com.example.web_shop.EntitiesInfo.ShoppingCartInfo;
import com.example.web_shop.Handlers.ShoppingCart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAO extends ShoppingCart {
    private final static String url = "jdbc:mysql://127.0.0.1:3306/workshop";
    private final static String username = "root";
    private final static String password = "123456_S";
    public ShoppingCartDAO(int id, int productId, int userId, int inStock) {
       super(id, productId, userId, inStock);
    }
    public static List<ShoppingCart> getCartForUser(int userId) throws SQLException {
        List<ShoppingCart> shoppingCartItems = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM shoppingcart WHERE userId = ?");

            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int productId = rs.getInt("productId");
                int inStock = rs.getInt("inStock");
                shoppingCartItems.add(new ShoppingCartDAO(id, productId, userId, inStock));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCartItems;
    }
    public static void addProductToCart(int productId, int userId, int quantity) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM shoppingcart WHERE userId = ? AND productId = ?");
            selectStatement.setInt(1, userId);
            selectStatement.setInt(2, productId);
            ResultSet existingItem = selectStatement.executeQuery();

            if (existingItem.next()) {
                int currentQuantity = existingItem.getInt("inStock");
                int newQuantity = currentQuantity + quantity;

                PreparedStatement updateStatement = con.prepareStatement("UPDATE shoppingcart SET inStock = ? WHERE userId = ? AND productId = ?");
                updateStatement.setInt(1, newQuantity);
                updateStatement.setInt(2, userId);
                updateStatement.setInt(3, productId);
                updateStatement.executeUpdate();
            } else {

                PreparedStatement insertStatement = con.prepareStatement("INSERT INTO shoppingcart (productId, userId, inStock) VALUES (?, ?, ?)");
                insertStatement.setInt(1, productId);
                insertStatement.setInt(2, userId);
                insertStatement.setInt(3, quantity);
                insertStatement.executeUpdate();
            }

            existingItem.close();
            selectStatement.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}