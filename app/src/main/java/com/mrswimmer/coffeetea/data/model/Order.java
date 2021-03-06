package com.mrswimmer.coffeetea.data.model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    ArrayList<ProductInBasket> products;
    int sum;
    Date date;
    String id;
    String userId;

    public Order(ArrayList<ProductInBasket> products, int sum, Date date, String userId) {
        this.products = products;
        this.sum = sum;
        this.date = date;
        this.userId = userId;
    }

    public Order(ArrayList<ProductInBasket> products, int sum, Date date) {
        this.products = products;
        this.sum = sum;
        this.date = date;
    }

    public Order() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<ProductInBasket> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductInBasket> products) {
        this.products = products;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getDateString() {
        return getDate().getDay() + "." + getDate().getMonth();
    }
}
