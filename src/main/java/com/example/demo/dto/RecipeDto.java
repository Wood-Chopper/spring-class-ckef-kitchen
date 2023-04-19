package com.example.demo.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeDto {
    private String name;
    private List<QuantityDto> quantities = new ArrayList<>();

    public RecipeDto(String name) {
        this.name = name;
    }

    public void addQuantity(IngredientDto ingredientDto, double value, String unit) {
        quantities.add(new QuantityDto(value, unit, ingredientDto));
    }
}
