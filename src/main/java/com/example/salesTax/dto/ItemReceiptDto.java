package com.example.salesTax.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Data
public class ItemReceiptDto {
    private String nameOnReceipt;
    private BigDecimal itemPrice;

    public ItemReceiptDto(String nameOnReceipt, BigDecimal itemPrice) {
        this.nameOnReceipt = nameOnReceipt;
        this.itemPrice = itemPrice;
    }

    public String getNameOnReceipt() {
        return nameOnReceipt;
    }

    public void setNameOnReceipt(String nameOnReceipt) {
        this.nameOnReceipt = nameOnReceipt;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}
