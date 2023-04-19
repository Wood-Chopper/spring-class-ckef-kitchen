package com.example.demo.controller;

import com.example.demo.dto.ChefDto;
import com.example.demo.dto.IngredientDto;
import com.example.demo.dto.KitchenDto;
import com.example.demo.dto.RecipeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chef")
public class ChefController {

    @GetMapping
    public ChefDto getChef() {
        ChefDto gordonRamsay = new ChefDto("Gordon Ramsay", 3);
        gordonRamsay.setKitchen(new KitchenDto("New York"));

        gordonRamsay.addRecipe(getRecipe());
        gordonRamsay.addRecipe(new RecipeDto("Spaghetti"));

        return gordonRamsay;
    }

    private RecipeDto getRecipe() {
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
