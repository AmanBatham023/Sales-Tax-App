package com.example.salesTax.service;

import com.example.salesTax.entity.Item;
import com.example.salesTax.entity.Receipt;
import com.example.salesTax.entity.ReceiptLineItem;
import com.example.salesTax.entity.TaxPolicy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Shop {
        private final List<Item> items = new ArrayList<>();

        public void addItem(Item item) {
            this.items.add(item);
        }
        public Receipt generateReceipt(TaxPolicy taxPolicy) {
            List<ReceiptLineItem> lineItems = new ArrayList<>();
            BigDecimal totalSalesTax = BigDecimal.ZERO;
            BigDecimal grandTotal = BigDecimal.ZERO;

            for (Item item : items) {
                BigDecimal itemTax = item.getSalesTax(taxPolicy);
                BigDecimal itemPriceWithTax = item.getPriceWithTax(taxPolicy);

                lineItems.add(new ReceiptLineItem(item.getQuantity(), item.getName(), itemPriceWithTax));

                totalSalesTax = totalSalesTax.add(itemTax);
                grandTotal = grandTotal.add(itemPriceWithTax);
            }

            return new Receipt(lineItems, totalSalesTax, grandTotal);
        }

}
