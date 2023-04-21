package com.example.demo.service;

import com.example.demo.dto.IngredientDto;
import com.example.demo.dto.QuantityDto;
import com.example.demo.entity.QuantityEntity;
import com.example.demo.repository.QuantityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuantityService {

    private final QuantityRepository repository;

    public List<QuantityDto> findByBValueAndName(double minValue, String unit) {
        List<QuantityEntity> quantityEntities =
                repository.sameThanFirstMethod(minValue, unit);

        return mapToDto(quantityEntities);
    }

    public List<QuantityDto> quantitiesGivenChef(String chef) {
        List<QuantityEntity> quantityEntities =
                repository.getQuantitiesGivenChef("%" + chef + "%");

        return mapToDto(quantityEntities);
    }

    private static List<QuantityDto> mapToDto(List<QuantityEntity> quantityEntities) {
        return quantityEntities.stream()
                .map(q ->
                        new QuantityDto(q.getQuantity(), q.getUnit(), new IngredientDto(q.getIngredient().getName()))
                ).toList();
    }
}
