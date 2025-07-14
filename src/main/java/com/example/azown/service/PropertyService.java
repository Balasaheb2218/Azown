package com.example.azown.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.azown.entity.Property;
import com.example.azown.repository.PropertyRepository;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Property createPropDetails(Property property) {
        return propertyRepository.save(property);
    }

    public String findPropDetailsById(Long id) {
        Optional<Property> opIdOwner = propertyRepository.findById(id);
        return opIdOwner.isPresent() ? "Record Found" : "Property record not found";
    }

    public List<Property> findAllPropDetails() {
        return propertyRepository.findAll();
    }

    public Property updateProperty(Long id, Property updateProperty) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        if (optionalProperty.isPresent()) {
            Property existingProperty = optionalProperty.get();

            if (updateProperty.getName() != null)
                existingProperty.setName(updateProperty.getName());

            if (updateProperty.getConfig() != null)
                existingProperty.setConfig(updateProperty.getConfig());

            if (updateProperty.getAmenities() != null)
                existingProperty.setAmenities(updateProperty.getAmenities());

            if (updateProperty.getSellPrice() != null)
                existingProperty.setSellPrice(updateProperty.getSellPrice());

            if (updateProperty.getRentalPrice() != null)
                existingProperty.setRentalPrice(updateProperty.getRentalPrice());

            if (updateProperty.getCarpet_area() != null)
                existingProperty.setCarpet_area(updateProperty.getCarpet_area());

            if (updateProperty.getPropertyAge() != null)
                existingProperty.setPropertyAge(updateProperty.getPropertyAge());

            if (updateProperty.getAddress() != null)
                existingProperty.setAddress(updateProperty.getAddress());

            return propertyRepository.save(existingProperty);
        } else {
            throw new RuntimeException("Property not found with ID: " + id);
        }
    }
}
