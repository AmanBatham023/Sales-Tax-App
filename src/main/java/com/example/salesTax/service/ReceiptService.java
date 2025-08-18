package com.example.salesTax.service;

import com.example.salesTax.dto.Receipt;

import java.util.List;

public interface ReceiptService {
    public Receipt getReceipt(List<String> inputData);
}
