package com.example.demo.service;

import com.example.demo.entity.IngredientEntity;
import com.example.demo.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private IngredientRepository repository;

    public IngredientService(IngredientRepository repo) {
        this.repository = repo;
    }

    public int addIngredient(String ingredient) {
        IngredientEntity ingredientEntity = new IngredientEntity(ingredient);
        IngredientEntity saved = repository.save(ingredientEntity);
        return saved.getId();
    }

    public Collection<String> getAllIngredients() {
        List<IngredientEntity> all = repository.findAll();

        return all.stream().map(entity -> entity.getName()).toList();
    }

    public String getIngredient(int id) {
        Optional<IngredientEntity> ingredientOptional = repository.findById(id);
        String name = ingredientOptional.map(entity -> entity.getName()).orElse(null);
        return name;
    }

    public void update(int id, String name) {
        IngredientEntity entity = new IngredientEntity(name);
        entity.setId(id);
        repository.save(entity);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
