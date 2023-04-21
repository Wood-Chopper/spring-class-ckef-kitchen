package com.example.demo.service;

import com.example.demo.dto.ChefDto;
import com.example.demo.dto.RecipeDto;
import com.example.demo.entity.ChefEntity;
import com.example.demo.repository.ChefRepository;
import org.springframework.stereotype.Service;

@Service
public class ChefService {

    private ChefRepository repository;

    public ChefService(ChefRepository repository) {
        this.repository = repository;
    }

    public int addChef(String name) {
        ChefEntity chefEntity = new ChefEntity(name);
        return repository.save(chefEntity).getId();
    }

    public ChefDto getChef(int id) {
        ChefEntity chefEntity = repository.getReferenceById(id);
        return mapChef(chefEntity);
    }

    // TODO test to return entity
    private ChefDto mapChef(ChefEntity entity) {
        ChefDto chefDto = new ChefDto(entity.getName());
        entity.getRecipes().forEach(recipeEntity -> {
            chefDto.addRecipe(new RecipeDto(recipeEntity.getName()));
        });
        return chefDto;
    }
}
