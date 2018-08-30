package com.process.model;

public class ProductDetail {

    public ProductDetail(){

    }

    public ProductDetail(int quantity, double amount){
        this.quantity = quantity;
        this.amount = amount;
    }

    private int quantity;

    private double amount;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
