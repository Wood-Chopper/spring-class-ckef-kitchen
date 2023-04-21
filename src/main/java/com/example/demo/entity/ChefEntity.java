package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "chef")
@NoArgsConstructor
public class ChefEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "chef", cascade = CascadeType.ALL)
    private List<RecipeEntity> recipes;

    public ChefEntity(String name) {
        this.name = name;
    }

    public void addRecipe(RecipeEntity recipe) {
        recipes.add(recipe);
        recipe.setChef(this);
    }
}
