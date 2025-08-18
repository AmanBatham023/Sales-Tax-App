package com.example.salesTax.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class AmountUtil {
    private static final BigDecimal ROUNDING_FACTOR = new BigDecimal("0.05");

    private AmountUtil(){

    }
    public static BigDecimal roundUp(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal divided = value.divide(ROUNDING_FACTOR, 0, RoundingMode.UP);
        return divided.multiply(ROUNDING_FACTOR);
    }
}
