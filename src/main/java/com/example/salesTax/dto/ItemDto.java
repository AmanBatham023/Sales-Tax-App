package com.example.salesTax.dto;

import com.example.salesTax.entity.CodeConstants;
import com.example.salesTax.util.AmountUtil;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

public class ItemDto {
    private final CodeConstants codeConstants;
    @Min(value = 1,message = "Quantity should not be empty.")
    private Integer itemQuantity;
    @Min(value = 1,message = "Name should be more than character.")
    private String itemName;
    @DecimalMin(value = "0.0", message = "Amount should be more than 0.0")
    private BigDecimal itemPrice;

    private Boolean isImported;
    private Boolean isExempt;

    public ItemDto(CodeConstants codeConstants, Integer itemQuantity, String itemName, BigDecimal itemPrice, Boolean isImported, Boolean isExempt) {
        this.codeConstants = codeConstants;
        this.itemQuantity = itemQuantity;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Boolean getImported() {
        return isImported;
    }

    public void setImported(Boolean imported) {
        isImported = imported;
    }

    public Boolean getExempt() {
        return isExempt;
    }

    public void setExempt(Boolean exempt) {
        isExempt = exempt;
    }

    public  BigDecimal calcTax(ItemDto itemDto){
        BigDecimal totalRate = BigDecimal.ZERO;
        if(!itemDto.getExempt()){
            totalRate = totalRate.add(codeConstants.normalRate);
        }
        if(itemDto.getImported()){
            totalRate = totalRate.add(codeConstants.importRate);
        }
        BigDecimal rawTax = itemDto.getItemPrice().multiply(totalRate).divide(new BigDecimal("100"));
        return AmountUtil.roundUp(rawTax);
    }
    public BigDecimal getFinalPrice(ItemDto item) {
        BigDecimal salesTax = calcTax(this);
        return itemPrice.add(salesTax).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal salesTaxAmount() {
        return calcTax(this);
    }

}
