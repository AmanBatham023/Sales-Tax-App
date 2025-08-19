package com.example.salesTax.entity;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {

    private final List<ReceiptLineItem> lineItems;
    private final BigDecimal totalSalesTax;
    private final BigDecimal grandTotal;

    public Receipt(List<ReceiptLineItem> lineItems, BigDecimal totalSalesTax, BigDecimal grandTotal) {
        this.lineItems = lineItems;
        this.totalSalesTax = totalSalesTax;
        this.grandTotal = grandTotal;
    }

    public void printReceipt() {
        for (ReceiptLineItem item : lineItems) {
            System.out.println(item.toString());
        }
        System.out.printf("Sales Taxes: %.2f%n", totalSalesTax);
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
