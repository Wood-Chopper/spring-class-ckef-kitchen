package com.example.demo.controller;

import com.example.demo.dto.IngredientRequestDto;
import com.example.demo.entity.IngredientEntity;
import com.example.demo.repository.IngredientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
class IngredientControllerTest {
    // Test dependencies are imported using @Autowired
    @Autowired
    MockMvc mockMvc;

    // EntityManager is a low-level repository
    @Autowired
    EntityManager em;

    // Used to transform objects to JSON
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testAdd() throws Exception {
        // Arrange
        IngredientRequestDto ingredientRequestDto = new IngredientRequestDto();
        ingredientRequestDto.setName("Mascarpone");
        String content = objectMapper.writeValueAsString(ingredientRequestDto);

        // Act
        MockHttpServletRequestBuilder requestBuilder = post("/ingredients")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON);
        byte[] result = mockMvc.perform(requestBuilder)
                .andReturn()
                .getResponse()
                .getContentAsByteArray();
        // Assert
        int resultInt = Integer.valueOf(new String(result));
        IngredientEntity entity = em.find(IngredientEntity.class, resultInt);
        assertEquals("Mascarpone", entity.getName());
    }

}