package com.example.salesTax.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CodeConstants {

    @Value("${sales.tax.normal.rate}")
    public BigDecimal normalRate;

    @Value("${sales.tax.imported.rate}")
    public BigDecimal importRate;

}
