package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuantityDto {
    private double value;
    private String unit;
    private IngredientDto ingredient;
}
