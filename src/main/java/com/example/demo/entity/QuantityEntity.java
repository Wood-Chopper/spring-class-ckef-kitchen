package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "quantity")
@Entity
public class QuantityEntity {

    @EmbeddedId
    private QuantityKey id = new QuantityKey();

    @Column(nullable = false)
    private double quantity;

    @Column(nullable = true)
    private String unit;

    @MapsId("recipeId")
    @ManyToOne(cascade = CascadeType.ALL)
    private RecipeEntity recipe;

    @MapsId("ingredientId")
    @ManyToOne(cascade = CascadeType.ALL)
    private IngredientEntity ingredient;
}
