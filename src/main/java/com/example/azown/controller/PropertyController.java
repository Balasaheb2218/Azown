package com.example.azown.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.azown.entity.Property;
import com.example.azown.service.PropertyService;

@RestController
@RequestMapping("/Property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    // Create property
    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        Property created = propertyService.createPropDetails(property);
        return ResponseEntity.ok(created);
    }

    // Find property by ID
    @GetMapping("/{id}")
    public ResponseEntity<String> findPropertyById(@PathVariable Long id) {
        String result = propertyService.findPropDetailsById(id);
        if (result.equals("Record Found")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(404).body(result);
        }
    }

    // Get all properties
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.ok(propertyService.findAllPropDetails());
    }

    // Update property by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProperty(@PathVariable Long id, @RequestBody Property property) {
        try {
            Property updated = propertyService.updateProperty(id, property);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Error: " + e.getMessage());
        }
    }
}
