package com.example.demo.repository;

import com.example.demo.entity.ChefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefRepository extends JpaRepository<ChefEntity, Integer> {

}
