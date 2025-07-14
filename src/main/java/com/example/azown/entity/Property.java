package com.example.azown.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Property {
  @Id
  Long id;
  
  String name;
  
  String config;
  
  String amenities;
  
  Double sellPrice;
  
  Double rentalPrice;
  
  Double carpet_area;
  
  Long propertyAge;
 
  @OneToOne
  Address address;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getConfig() {
	return config;
}

public void setConfig(String config) {
	this.config = config;
}

public String getAmenities() {
	return amenities;
}

public void setAmenities(String amenities) {
	this.amenities = amenities;
}

public Double getSellPrice() {
	return sellPrice;
}

public void setSellPrice(Double sellPrice) {
	this.sellPrice = sellPrice;
}

public Double getRentalPrice() {
	return rentalPrice;
}

public void setRentalPrice(Double rentalPrice) {
	this.rentalPrice = rentalPrice;
}

public Double getCarpet_area() {
	return carpet_area;
}

public void setCarpet_area(Double carpet_area) {
	this.carpet_area = carpet_area;
}

public Long getPropertyAge() {
	return propertyAge;
}

public void setPropertyAge(Long propertyAge) {
	this.propertyAge = propertyAge;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}
  
  
  
}