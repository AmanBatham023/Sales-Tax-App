package com.example.salesTax.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumSet;
import java.util.Set;

public class TaxPolicy {
    private static final BigDecimal BASIC_SALES_TAX_RATE = new BigDecimal("0.10");
    private static final BigDecimal IMPORT_DUTY_RATE = new BigDecimal("0.05");
    private static final BigDecimal ROUNDING_FACTOR = new BigDecimal("0.05");
    private static final Set<ProductCategory> EXEMPT_CATEGORIES = EnumSet.of(
            ProductCategory.BOOK,
            ProductCategory.FOOD,
            ProductCategory.MEDICAL
    );

    public BigDecimal getTaxRateForItem(Item item) {
        BigDecimal taxRate = BigDecimal.ZERO;

        if (!EXEMPT_CATEGORIES.contains(item.getCategory())) {
            taxRate = taxRate.add(BASIC_SALES_TAX_RATE);
        }

        if (item.isImported()) {
            taxRate = taxRate.add(IMPORT_DUTY_RATE);
        }

        return taxRate;
    }

    public BigDecimal roundUp(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal divided = value.divide(ROUNDING_FACTOR, 0, RoundingMode.UP);
        return divided.multiply(ROUNDING_FACTOR);
    }
}
