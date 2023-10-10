package com.example.web_shop.Handlers;

import com.example.web_shop.Dao.ProductDAO;
import com.example.web_shop.EntitiesInfo.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class ProductHandler {

    public ProductHandler() {
    }

    public static List<ProductInfo> getAllProducts() {
        ArrayList<ProductInfo> productsList = new ArrayList<>();
        ArrayList<Product> products = (ArrayList<Product>) Product.selectAllProducts();

        for (int i = 0; i < products.size(); i++) {
            productsList.add(i, new ProductInfo(products.get(i).getId(), products.get(i).getName(), products.get(i).getDescription(), products.get(i).getImage(), products.get(i).getCost() ) );
        }

        return productsList;
    }

    public static ProductInfo getProductById(int productId) {
        Product oneProduct = Product.selectProduct(productId);

        return new ProductInfo(productId, oneProduct.getName(), oneProduct.getDescription(), oneProduct.getImage(), oneProduct.getCost());
    }

}