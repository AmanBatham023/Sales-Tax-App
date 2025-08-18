package com.example.salesTax.controller;

import com.example.salesTax.dto.Receipt;
import com.example.salesTax.service.ReceiptService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getReceipt")
public class ReceiptController {

    @Autowired
    ReceiptService receiptService;

    @PostMapping(value = "/print")
    public ResponseEntity<Receipt> printReceipt (@RequestBody List<String> items){
       return new ResponseEntity<>(receiptService.getReceipt(items), HttpStatus.OK);
    }
}
