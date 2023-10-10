package com.example.web_shop.EntitiesInfo;

public class ShoppingCartInfo {
    private int id;
    private int productId;
    private int userId;
    private int inStock;

    public ShoppingCartInfo(int id, int productId, int userId, int inStock) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.inStock = inStock;
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
