package com.example.demo.service;

import com.example.demo.dto.IngredientDto;
import com.example.demo.entity.IngredientEntity;
import com.example.demo.repository.IngredientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

class IngredientServiceTest {

    private IngredientRepository repository = Mockito.mock(IngredientRepository.class);
    private IngredientService service = new IngredientService(repository);

    @Test
    void addIngredient() {
        // Arrange
        String ingredient = "Mascarpone";
        IngredientEntity saved = new IngredientEntity();
        saved.setId(5);
        ArgumentCaptor<IngredientEntity> captor = ArgumentCaptor.forClass(IngredientEntity.class);
        Mockito.when(repository.save(captor.capture())).thenReturn(saved);

        // Act
        int id = service.addIngredient(ingredient);

        // Assert
        assertTrue(id > 0);
        assertEquals("Mascarpone", captor.getValue().getName());
    }

    @Test
    void getIngredient_isFound() {
        // Arrange
        IngredientEntity entity = new IngredientEntity("Egg");
        Mockito
                .when(repository.findById(anyInt())) // capture inputs
                .thenReturn(Optional.of(entity)); // fake return value

        // Act
        String ingredient = service.getIngredient(1);

        // Assert
        assertEquals("Egg", ingredient);
    }

    @Test
    void getIngredient_idIsUsed() {
        // Arrange
        IngredientEntity entity = new IngredientEntity("Egg");
        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito
                .when(repository.findById(idCaptor.capture())) // capture inputs
                .thenReturn(Optional.of(entity)); // fake return value

        // Act
        String ingredient = service.getIngredient(5);

        // Assert
        assertEquals(5, idCaptor.getValue());
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