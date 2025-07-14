package com.example.azown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.azown.entity.Property;
import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
public List<Property> findByNameIgnoreCase(String name);
}
