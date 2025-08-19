package com.example.salesTax.util;

import com.example.salesTax.entity.Item;
import com.example.salesTax.entity.ProductCategory;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final Pattern INPUT_PATTERN = Pattern.compile("(\\d+)\\s+(.+)\\s+at\\s+([\\d.]+)");

    public Item parse(String line) {
        Matcher matcher = INPUT_PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input format: " + line);
        }

        int quantity = Integer.parseInt(matcher.group(1));
        String name = matcher.group(2).trim();
        BigDecimal price = new BigDecimal(matcher.group(3));

        boolean isImported = name.contains("imported");
        ProductCategory category = categorize(name);

        return new Item(name, price, isImported, category, quantity);
    }

    private ProductCategory categorize(String name) {
        if (name.contains("book")) {
            return ProductCategory.BOOK;
        }
        if (name.contains("chocolate") || name.contains("chocolates")) {
            return ProductCategory.FOOD;
        }
        if (name.contains("pills")) {
            return ProductCategory.MEDICAL;
        }
        return ProductCategory.OTHER;
    }
}
