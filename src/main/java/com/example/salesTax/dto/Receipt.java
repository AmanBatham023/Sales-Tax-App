package com.example.salesTax.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@Data
public class Receipt {
    private List<ItemReceiptDto> items;
    private BigDecimal totalAmount;
    private BigDecimal totalTaxAmt;

    public Receipt(List<ItemReceiptDto> items, BigDecimal totalAmount, BigDecimal totalTaxAmt) {
        this.items = items;
        this.totalAmount = totalAmount;
        this.totalTaxAmt = totalTaxAmt;
    }

    public Receipt() {

    }

    public List<ItemReceiptDto> getItems() {
        return items;
    }

    public void setItems(List<ItemReceiptDto> items) {
        this.items = items;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalTaxAmt() {
        return totalTaxAmt;
    }

    public void setTotalTaxAmt(BigDecimal totalTaxAmt) {
        this.totalTaxAmt = totalTaxAmt;
    }
}
