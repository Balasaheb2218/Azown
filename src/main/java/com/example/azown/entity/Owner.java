package com.example.azown.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Owner {
     @Id 
	Long id;
     
     String name;
     
     String email;
     
     Long contact;
     
     @OneToMany
    List <Property> properties ;
     
     
     @OneToOne
     Address address;

     @Transient
     String qualification;
     
     Long pincode;

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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getContact() {
		return contact;
	}


	public void setContact(Long contact) {
		this.contact = contact;
	}


	public List<Property> getProperties() {
		return properties;
	}


	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
