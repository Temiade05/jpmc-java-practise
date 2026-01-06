package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity // <--- New Sticker: "Make a table called Trade"
public class Trade {

    @Id // <--- New Sticker: "This is the Primary Key"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String ticker;

    @Positive
    private double price;

    @Min(1)
    private int quantity;

    // Default Constructor (Required by JPA)
    public Trade() {}

    public Trade(String ticker, double price, int quantity) {
        this.ticker = ticker;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public Long getId() { return id; }
    public String getTicker() { return ticker; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
