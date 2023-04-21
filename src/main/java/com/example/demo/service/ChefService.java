package com.example.demo.service;

import com.example.demo.dto.ChefDto;
import com.example.demo.dto.RecipeDto;
import com.example.demo.entity.ChefEntity;
import com.example.demo.entity.RecipeEntity;
import com.example.demo.repository.ChefRepository;
import com.example.demo.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class ChefService {

    private ChefRepository repository;
    private RecipeRepository recipeRepository;

    public ChefService(ChefRepository repository, RecipeRepository recipeRepository) {
        this.repository = repository;
        this.recipeRepository = recipeRepository;
    }

    public int addChef(String name) {
        ChefEntity chefEntity = new ChefEntity(name);
        return repository.save(chefEntity).getId();
    }

    public ChefDto getChef(int id) {
        ChefEntity chefEntity = repository.getReferenceById(id);
        return mapChef(chefEntity);
    }

    public int addRecipeToChef(int chefId, String recipeName) {
        ChefEntity chefEntity = repository.getReferenceById(chefId);
        RecipeEntity recipeEntity = new RecipeEntity(recipeName);

        chefEntity.addRecipe(recipeEntity);

        RecipeEntity saved = recipeRepository.save(recipeEntity);
        return saved.getId();
    }

    private ChefDto mapChef(ChefEntity entity) {
        ChefDto chefDto = new ChefDto(entity.getName());
        entity.getRecipes().forEach(recipeEntity -> {
            chefDto.addRecipe(new RecipeDto(recipeEntity.getName()));
        });
        return chefDto;
    }
}
