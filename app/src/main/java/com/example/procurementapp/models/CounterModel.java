package com.example.procurementapp.models;

public class CounterModel {

    String productName;
    String productPrice;

    public String getSuplierName() {
        return suplierName;
    }

    public void setSuplierName(String suplierName) {
        this.suplierName = suplierName;
    }

    public CounterModel(String suplierName) {
        this.suplierName = suplierName;
    }

    String suplierName;

    //Create Cnstructor
    public CounterModel(String productName, String productPrice, String totalqty, String currentDate, String currentTime, int totalPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.totalqty = totalqty;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.totalPrice = totalPrice;
    }

    String totalqty;

    //Create getters and setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(String totalqty) {
        this.totalqty = totalqty;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CounterModel() {
    }

    String currentDate;
    String currentTime;
    int totalPrice;


}
