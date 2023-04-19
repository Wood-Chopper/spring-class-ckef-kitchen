package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChefDto {
    private String name;
    private int stars;
    private KitchenDto kitchen;
    private List<RecipeDto> recipes = new ArrayList<>();

    public ChefDto(String name, int stars) {
        this.name = name;
        this.stars = stars;
    }

    public void addRecipe(RecipeDto recipe) {
        this.recipes.add(recipe);
    }
}
