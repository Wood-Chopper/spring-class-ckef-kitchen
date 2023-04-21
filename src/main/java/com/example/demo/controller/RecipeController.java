package com.example.demo.controller;

import com.example.demo.dto.AddQuantityRequestDto;
import com.example.demo.service.RecipeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("recipes")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("{id}/quantities")
    public void addQuantity(@RequestBody AddQuantityRequestDto addQuantityRequestDto, @PathVariable("id") int id) {
        recipeService.addQuantity(id, addQuantityRequestDto);
    }
}
