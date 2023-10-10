package com.example.web_shop.Dao;

import com.example.web_shop.EntitiesInfo.ProductInfo;
import com.example.web_shop.Handlers.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends Product {
    private final static String url = "jdbc:mysql://127.0.0.1:3306/workshop";
    private final static String username = "root";
    private final static String password = "123456_S";

    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM products";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM products WHERE id = ?";
    public ProductDAO(int id, String name, String description, String image, double cost) {
        super(id, name, description, image, cost);
    }
    public static List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double cost = rs.getDouble("cost");
                products.add(new ProductDAO(id, name, description, image, cost));
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public static Product selectProduct(int productId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double cost = rs.getDouble("cost");
                return new ProductDAO(id, name, description, image, cost);
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}