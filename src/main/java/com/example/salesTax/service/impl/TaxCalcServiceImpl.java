package com.example.salesTax.service.impl;

import com.example.salesTax.dto.ItemDto;
import com.example.salesTax.entity.CodeConstants;
import com.example.salesTax.service.TaxCalcService;
import com.example.salesTax.util.AmountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TaxCalcServiceImpl implements TaxCalcService {

    @Autowired
    CodeConstants codeConstants;

    @Override
    public BigDecimal calcTax(ItemDto itemDto){
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
}
