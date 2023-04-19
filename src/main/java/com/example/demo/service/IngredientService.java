package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {

    private Map<Integer, String> ingredients = new HashMap<>();

    private int lastId = 0;

    public int addIngredient(String ingredient) {
        int id = lastId;
        lastId = lastId + 1;

        ingredients.put(id, ingredient);

        return id;
    }

    public Collection<String> getAllIngredients() {
        return ingredients.values();
    }

    public String getIngredient(int id) {
        return ingredients.get(id);
    }
}
