package com.example.demo.service;

import com.example.demo.entity.IngredientEntity;
import com.example.demo.repository.IngredientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IngredientServiceTest {

    private IngredientRepository ingredientRepository = Mockito.mock(IngredientRepository.class);
    private IngredientService service = new IngredientService(ingredientRepository);

    @Test
    void addIngredient() {
        // Arrange
        String ingredient = "Mascarpone";
        IngredientEntity saved = new IngredientEntity();
        saved.setId(5);
        ArgumentCaptor<IngredientEntity> captor = ArgumentCaptor.forClass(IngredientEntity.class);
        Mockito.when(ingredientRepository.save(captor.capture())).thenReturn(saved);

        // Act
        int id = service.addIngredient(ingredient);

        // Assert
        assertTrue(id > 0);
        assertEquals("Mascarpone", captor.getValue().getName());
    }

    @Test
    void update() {
        // TODO
    }

    @Test
    void getIngredient() {
        // How to create an optional
        Optional<String> stringOptional = Optional.of("Mascarpone");
        // Create an empty optional
        Optional<String> emptyOptional = Optional.empty();

        // TODO
    }
}