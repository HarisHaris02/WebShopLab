package com.example.web_shop.Handlers;

import com.example.web_shop.Dao.ProductDAO;
import com.example.web_shop.Dao.ShoppingCartDAO;
import com.example.web_shop.EntitiesInfo.ProductInfo;
import com.example.web_shop.EntitiesInfo.ShoppingCartInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartHandler {



    public static void addToCart(int productId, int userId, int quantity) throws SQLException {
        ShoppingCart.addProductToCart(productId, userId, quantity);
    }

    public static List<ShoppingCartInfo> getCartForUser(int userId) throws SQLException {
       List<ShoppingCart> shoppingCart = ShoppingCart.getCartForUser(userId);
       ArrayList<ShoppingCartInfo> shoppingCartInfo = new ArrayList<>();
       for (int i = 0; i < shoppingCart.size(); i++) {
           shoppingCartInfo.add(i, new ShoppingCartInfo(shoppingCart.get(i).getId(), shoppingCart.get(i).getProductId(), shoppingCart.get(i).getUserId(), shoppingCart.get(i).getInStock()));
       }
        return shoppingCartInfo;
    }

}