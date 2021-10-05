package com.example.procurementapp.models;

public class ViewAllModel {

    //declare variables
    String name;
    int price;
    String qty;
    String sup;
    String img_url;

    public ViewAllModel() {
    }

    //Create getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSup() {
        return sup;
    }

    public void setSup(String sup) {
        this.sup = sup;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    //Create constructor
    public ViewAllModel(String name, int price, String qty, String sup, String img_url) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.sup = sup;
        this.img_url = img_url;
    }
}
