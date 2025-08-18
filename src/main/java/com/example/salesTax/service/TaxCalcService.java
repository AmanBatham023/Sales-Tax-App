package com.example.salesTax.service;

import com.example.salesTax.dto.ItemDto;

import java.math.BigDecimal;

@FunctionalInterface
public interface TaxCalcService {
    public BigDecimal calcTax(ItemDto itemDto);
}
