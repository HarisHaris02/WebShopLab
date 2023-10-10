package com.example.web_shop.EntitiesInfo;

public class ProductInfo {
    private int id;
    private String name;
    private String description;
    private String image;
    private double cost;

    public ProductInfo(int id, String name, String description, String image, double cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
