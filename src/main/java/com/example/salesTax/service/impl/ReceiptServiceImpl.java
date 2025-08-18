package com.example.salesTax.service.impl;

import com.example.salesTax.dto.ItemDto;
import com.example.salesTax.dto.ItemReceiptDto;
import com.example.salesTax.dto.Receipt;
import com.example.salesTax.service.ItemsDtoToItem;
import com.example.salesTax.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptServiceImpl  implements ReceiptService {

    @Autowired
    ItemsDtoToItem itemsDtoToItem;
    public Receipt getReceipt(List<String> inputData){
        Receipt receipt = new Receipt();
        List<ItemDto> items = itemsDtoToItem.parse(inputData);
        List<ItemReceiptDto> itemReceiptDtos = new ArrayList<>();
        BigDecimal totalSalesTax = BigDecimal.ZERO;
        BigDecimal totalAmount = BigDecimal.ZERO;

        for(ItemDto item: items){
            BigDecimal finalPrice = item.getFinalPrice(item);
            String receiptItemName = String.format("%d %s", item.getItemQuantity(), item.getItemName());
            itemReceiptDtos.add(new ItemReceiptDto(receiptItemName, finalPrice.setScale(2, RoundingMode.HALF_UP)));
            totalSalesTax = totalSalesTax.add(item.salesTaxAmount());
            totalAmount = totalAmount.add(finalPrice);
        }
        receipt.setItems(itemReceiptDtos);
        receipt.setTotalAmount(totalAmount);
        receipt.setTotalTaxAmt(totalSalesTax);
        return receipt;
    }

}
