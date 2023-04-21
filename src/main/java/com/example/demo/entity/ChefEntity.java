package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "chef")
    private Set<RecipeEntity> recipes;

    public ChefEntity(String name) {
        this.name = name;
    }
}
