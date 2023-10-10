package com.example.web_shop.Handlers;

import com.example.web_shop.Dao.ProductDAO;


import java.util.List;

public class Product {
    private int id;
    private String name;
    private String description;
    private String image;
    private double cost;

    public Product() {
    }

    protected Product(int id, String name, String description, String image, double cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.cost = cost;
    }
    protected static List<Product> selectAllProducts() {
        return ProductDAO.selectAllProducts();
    }
    public static Product selectProduct(int productId) {
        return ProductDAO.selectProduct(productId);
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public double getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
