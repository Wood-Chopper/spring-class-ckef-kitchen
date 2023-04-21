package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "recipe")
@NoArgsConstructor
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private ChefEntity chef;

    @OneToMany(mappedBy = "recipe")
    List<QuantityEntity> quantities;

    public RecipeEntity(String name) {
        this.name = name;
    }

    public void addQuantity(QuantityEntity quantityEntity) {
        this.quantities.add(quantityEntity);
        quantityEntity.setRecipe(this);
    }
}
