package com.example.demo.controller;

import com.example.demo.dto.IngredientRequestDto;
import com.example.demo.dto.IngredientDto;
import com.example.demo.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    // inject dependency
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int addIngredient(@RequestBody IngredientRequestDto ingredientRequestDto) {
        return ingredientService.addIngredient(ingredientRequestDto.getName());
    }

    @GetMapping("{id}")
    public ResponseEntity<IngredientDto> getIngredient(@PathVariable("id") int id) {
        String ingredient = ingredientService.getIngredient(id);
        if (ingredient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new IngredientDto(ingredient));
    }

    @PutMapping("{id}")
    public void updateIngredient(@PathVariable("id") int id, @RequestBody IngredientRequestDto ingredientRequestDto) {
        ingredientService.update(id, ingredientRequestDto.getName());
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable("id") int id) {
        ingredientService.delete(id);
    }

}
