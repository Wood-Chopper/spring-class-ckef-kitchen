package com.example.demo.repository;

import com.example.demo.entity.QuantityEntity;
import com.example.demo.entity.QuantityKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityRepository extends JpaRepository<QuantityEntity, QuantityKey> {
    List<QuantityEntity> findByQuantityGreaterThanAndUnit(double qu, String unit);

    @Query("SELECT q FROM QuantityEntity q WHERE q.quantity > :qu AND q.unit = :unit")
    List<QuantityEntity> sameThanFirstMethod(@Param("qu") double qu, @Param("unit") String unit);

    @Query("SELECT q FROM QuantityEntity q WHERE q.recipe.chef.name LIKE :chef")
    List<QuantityEntity> getQuantitiesGivenChef(@Param("chef") String chef);
}
