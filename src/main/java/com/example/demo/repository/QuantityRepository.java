package com.example.demo.repository;

import com.example.demo.entity.QuantityEntity;
import com.example.demo.entity.QuantityKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityRepository extends JpaRepository<QuantityEntity, QuantityKey> {
}
