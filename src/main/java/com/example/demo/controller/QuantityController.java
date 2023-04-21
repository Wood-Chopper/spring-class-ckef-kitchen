package com.example.demo.controller;

import com.example.demo.dto.QuantityDto;
import com.example.demo.service.QuantityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("quantities")
@RequiredArgsConstructor
public class QuantityController {

    private final QuantityService quantityService;

    @GetMapping
    public List<QuantityDto> filter(@RequestParam("unit") String unit, @RequestParam("value") double value) {
        return quantityService.findByBValueAndName(value, unit);
    }

    @GetMapping("chef")
    public List<QuantityDto> byChef(@RequestParam("chef") String chef) {
        return quantityService.quantitiesGivenChef(chef);
    }
}
