package com.example.demo.controller;

import com.example.demo.dto.IngredientDto;
import com.example.demo.dto.RecipeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloWorld {
    @GetMapping
    public String helloworld() {
        return "Hello world 4!";
    }

    @GetMapping("recipe")
    public RecipeDto getRecipe() {
        RecipeDto recipeDto = new RecipeDto("Tiramisu");

        IngredientDto mascarpone = new IngredientDto("Mascarpone");
        IngredientDto cacao = new IngredientDto("Cacao");
        IngredientDto boudoir = new IngredientDto("Boudoir");
        IngredientDto coffee = new IngredientDto("Coffee");
        IngredientDto sugar = new IngredientDto("Sugar");
        IngredientDto egg = new IngredientDto("Egg");

        recipeDto.addQuantity(mascarpone, 500, "g");
        recipeDto.addQuantity(cacao, 20, "g");
        recipeDto.addQuantity(boudoir, 40, "unit");
        recipeDto.addQuantity(coffee, 1.5, "dl");
        recipeDto.addQuantity(sugar, 200, "g");
        recipeDto.addQuantity(egg, 6, "unit");

        return recipeDto;
    }
}
