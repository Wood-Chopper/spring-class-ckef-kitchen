package com.example.demo.dto;

import lombok.Data;

@Data
public class AddQuantityRequestDto {
    private String ingredient;
    private double quantity;
    private String unit;
}
