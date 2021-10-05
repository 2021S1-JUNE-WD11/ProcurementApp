package com.example.procurementapp.models;

public class Recent_items_model {

    //declare variables
    String name;
    String supplier;
    String price;
    String quantity;
    String  img_url;

    public Recent_items_model() {
    }

    //Create constructor
    public Recent_items_model(String name, String supplier, String price, String quantity, String img_url) {
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.quantity = quantity;
        this.img_url = img_url;
    }

    //Create getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
