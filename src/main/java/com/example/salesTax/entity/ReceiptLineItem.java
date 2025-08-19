package com.example.salesTax.entity;

import java.math.BigDecimal;

public class ReceiptLineItem {
    private final int quantity;
    private final String name;
    private final BigDecimal price;

    public ReceiptLineItem(int quantity, String name, BigDecimal price) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%d %s: %.2f", quantity, name, price);
    }
}
