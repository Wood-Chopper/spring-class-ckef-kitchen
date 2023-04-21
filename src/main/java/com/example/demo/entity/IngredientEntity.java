package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "ingredient")
@Entity
@Data
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<QuantityEntity> quantities = new ArrayList<>();

    public IngredientEntity() {
    }

    public IngredientEntity(String name) {
        this.name = name;
    }

    public void addQuantity(QuantityEntity quantityEntity) {
        quantities.add(quantityEntity);
        quantityEntity.setIngredient(this);
    }
}
