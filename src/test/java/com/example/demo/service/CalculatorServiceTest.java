package com.example.demo.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {

    private CalculatorService service = new CalculatorService();

    @Test
    void sumList() {
        // Arrange the data of the test
        List<Integer> integers = List.of(1, 2, 3, 4);

        // Act, execute the method call
        int sum = service.sumList(integers);

        // Assert the result
        assertEquals(10, sum);
    }

    @Test
    void sumList_nullList() {
        // Arrange
        List<Integer> list = null;

        // Act
        int sum = service.sumList(list);

        // Assert
        assertEquals(0, sum);
    }

    @Test
    void occurrence() {
        List<String> list = List.of("toto", "john", "truc");

        int result = service.occurrence(list, "toto");

        assertEquals(1, result);
    }

    @Test
    void occurrence_twoOccurence() {
        List<String> list = List.of("toto", "john", "truc", "toto");

        int result = service.occurrence(list, "toto");

        assertEquals(2, result);
    }

    @Test
    void occurrence_nullInput() {
        List<String> list = List.of("toto", "john", "truc");

        int result = service.occurrence(list, null);

        assertEquals(0, result);
    }

    @Test
    void occurrence_nullList() {

        int result = service.occurrence(null, "toto");

        assertEquals(0, result);
    }

    @Test
    void occurrence_nullInList() {
        List<String> list = new ArrayList<>();
        list.add("toto");
        list.add(null);
        list.add("john");

        int result = service.occurrence(list, "toto");

        assertEquals(1, result);
    }

    @Test
    void occurrence_nullInList_nullElement() {
        List<String> list = new ArrayList<>();
        list.add("toto");
        list.add(null);
        list.add("john");

        int result = service.occurrence(list, null);

        assertEquals(1, result);
    }
}