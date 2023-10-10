package com.example.web_shop.Handlers;

import com.example.web_shop.Dao.ShoppingCartDAO;

import java.sql.SQLException;
import java.util.List;

public class ShoppingCart {
    private int id;
    private int productId;
    private int userId;
    private int inStock;

    protected ShoppingCart(int id, int productId, int userId, int inStock) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.inStock = inStock;
    }
    protected static void addProductToCart(int productId, int userId, int quantity) throws SQLException{
        ShoppingCartDAO.addProductToCart(productId, userId, quantity);
    }
    public static List<ShoppingCart> getCartForUser(int userId) throws SQLException {
        return ShoppingCartDAO.getCartForUser(userId);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInStock() {
            return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

}
