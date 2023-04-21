package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.ChefService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chefs")
public class ChefController {

    private ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    @PostMapping
    public int postChef(@RequestBody ChefRequestDto chefRequestDto) {
        return chefService.addChef(chefRequestDto.getName());
    }

    @GetMapping("{id}")
    public ChefDto getChefGivenId(@PathVariable("id") int id) {
        return chefService.getChef(id);
    }

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
