package com.example.salesTax.service;

import com.example.salesTax.dto.ItemDto;

import java.util.List;

public interface ItemsDtoToItem {
    public List<ItemDto> parse(List<String> inputs);
}
