package com.example.salesTax.service.impl;

import com.example.salesTax.dto.ItemDto;
import com.example.salesTax.entity.CodeConstants;
import com.example.salesTax.service.ItemsDtoToItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ItemDtoToItemsImpl implements ItemsDtoToItem {
    private static final Pattern INPUT_PATTERN = Pattern.compile("(\\d+)\\s(.*)\\sat\\s(\\d+\\.\\d{2})");

    @Autowired
    CodeConstants codeConstants;

    private List<String> exemptKeywords;

    public ItemDtoToItemsImpl(@Value("${tax.excluded.keywords}") String[] exemptKeywords) {
        this.exemptKeywords = Arrays.asList(exemptKeywords);
    }

    public List<ItemDto> parse(List<String> inputs) {
        ArrayList<ItemDto> items = new ArrayList<>();
        for(String inputLine: inputs){
            Matcher matcher = INPUT_PATTERN.matcher(inputLine);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Invalid input format: " + inputLine);
            }

            int quantity = Integer.parseInt(matcher.group(1));
            String name = matcher.group(2).trim();
            BigDecimal price = new BigDecimal(matcher.group(3));

            boolean isImported = name.contains("imported");
            boolean isExempt = exemptKeywords.stream().anyMatch(name::contains);
           items.add(new ItemDto(codeConstants, quantity, name, price, isImported, isExempt));
        }
        return items;
    }
}
