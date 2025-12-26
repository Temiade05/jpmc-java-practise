package com.example.demo;

public class Trade {
    private String ticker;
    private double price;
    private int quantity;

    // Constructor
    public Trade(String ticker, double price, int quantity) {
        this.ticker = ticker;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters (Needed for the JSON API to work)
    public String getTicker() { 
        return ticker; 
    }
    public double getPrice() { 
        return price; 
    }
    public int getQuantity() { 
        return quantity; 
    }
}