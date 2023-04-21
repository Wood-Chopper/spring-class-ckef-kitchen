package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class QuantityKey implements Serializable {
    @Column(name = "recipe_id")
    private int recipeId;
    @Column(name = "ingredient_id")
    private int ingredientId;
}
