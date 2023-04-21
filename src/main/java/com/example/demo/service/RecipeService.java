package com.example.demo.service;

import com.example.demo.dto.AddQuantityRequestDto;
import com.example.demo.entity.IngredientEntity;
import com.example.demo.entity.QuantityEntity;
import com.example.demo.entity.QuantityKey;
import com.example.demo.entity.RecipeEntity;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.QuantityRepository;
import com.example.demo.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;
    private QuantityRepository quantityRepository;
    private IngredientRepository ingredientRepository;

    public RecipeService(RecipeRepository recipeRepository, QuantityRepository quantityRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.quantityRepository = quantityRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public void addQuantity(int recipeId, AddQuantityRequestDto addQuantityRequestDto) {
        // Create / get entities
        RecipeEntity recipeEntity = recipeRepository.getReferenceById(recipeId);

        IngredientEntity ingredientEntity = new IngredientEntity(addQuantityRequestDto.getIngredient());

        QuantityEntity quantityEntity = new QuantityEntity();
        quantityEntity.setUnit(addQuantityRequestDto.getUnit());
        quantityEntity.setQuantity(addQuantityRequestDto.getQuantity());

        // Link entities
        recipeEntity.addQuantity(quantityEntity);
        ingredientEntity.addQuantity(quantityEntity);

        // Save
        ingredientRepository.save(ingredientEntity);
    }
}
