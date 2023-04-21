package com.example.demo.repository;

import com.example.demo.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository
        extends JpaRepository<IngredientEntity, Integer> {

    List<IngredientEntity> findByNameLike(String like);
}
