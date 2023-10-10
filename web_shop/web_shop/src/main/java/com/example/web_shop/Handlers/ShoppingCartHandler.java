package com.example.web_shop.Handlers;

import com.example.web_shop.Dao.ProductDAO;
import com.example.web_shop.Dao.ShoppingCartDAO;
import com.example.web_shop.EntitiesInfo.ProductInfo;
import com.example.web_shop.EntitiesInfo.ShoppingCartInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartHandler {



    public void addToCart(int productId, int userId, int quantity) throws SQLException {
        ShoppingCart.addProductToCart(productId, userId, quantity);
    }

    public List<ShoppingCartInfo> getCartForUser(int userId) throws SQLException {
       List<ShoppingCart> cart = ShoppingCart.getCartForUser(userId);
        return new ArrayList<ShoppingCartInfo>();
    }

}