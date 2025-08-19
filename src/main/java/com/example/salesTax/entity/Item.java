package com.example.salesTax.entity;

import java.math.BigDecimal;

public class Item {
    private final String name;
    private final BigDecimal shelfPrice;
    private final boolean isImported;
    private final ProductCategory category;
    private final int quantity;

    public Item(String name, BigDecimal shelfPrice, boolean isImported, ProductCategory category, int quantity) {
        this.name = name;
        this.shelfPrice = shelfPrice;
        this.isImported = isImported;
        this.category = category;
        this.quantity = quantity;
    }
    public BigDecimal getSalesTax(TaxPolicy policy) {
        BigDecimal taxRate = policy.getTaxRateForItem(this);
        if (taxRate.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        BigDecimal rawTax = this.shelfPrice.multiply(taxRate);
        return policy.roundUp(rawTax);
    }
    public BigDecimal getPriceWithTax(TaxPolicy policy) {
        return this.shelfPrice.add(getSalesTax(policy));
    }

    public String getName() { return name; }
    public BigDecimal getShelfPrice() { return shelfPrice; }
    public boolean isImported() { return isImported; }
    public ProductCategory getCategory() { return category; }
    public int getQuantity() { return quantity; }
}
