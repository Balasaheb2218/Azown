package com.example.azown.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.azown.entity.Owner;
import com.example.azown.repository.OwnerRepository;
@Service
public class OwnerService{
@Autowired
OwnerRepository ownerRepository;
	
	
	public Owner createOwnerDetails(Owner owner) {
		
		return ownerRepository.save(owner);

	}
	
	@Cacheable 
	public List<Owner> findAllOwnerDetails(){
		return ownerRepository.findAll();
		}
	@Transactional
	
	public Owner editOwnerDetails (Owner owner, Long id) {

		Optional<Owner> optional = ownerRepository.findById(id);

		if(optional.isPresent()) {
			Owner dbOwner=optional.get();
		if (owner.getAddress() != null) {
		dbOwner.setAddress(owner.getAddress());
		}
		if (owner.getProperties() != null) { 
			dbOwner.setProperties (owner.getProperties());
		}
		if (owner.getName() != null) {
		dbOwner.setName(owner.getName());
		}
		if (owner.getEmail() != null) {
		dbOwner.setEmail(owner.getEmail());
		}
		if (owner.getContact() != null) {
		dbOwner.setContact(owner.getContact());
		}
		owner=ownerRepository.save(dbOwner);
		}
		
		return owner;
	}
	
	public String deleteOwnerDetailsById(Long id) {
		Optional<Owner> opOwner=ownerRepository.findById(id);
		if(opOwner.isPresent()) {
			ownerRepository.deleteById(id);
			return "Owner deleted Successfully";
		}
		else {
			return "Owner records does not exist";
		}
	}
	
	//OwnerDetailsByID


	public String findOwnerDetailsById(Long id) {
		Optional<Owner> opIdOwner=ownerRepository.findById(id);
		if(opIdOwner.isPresent()) {
			return "Record Found";		
		}
		else {
	return "Owner records does not found";
		}
	}
	
	
	//use response entity
//	public Owner findOwnerDetailsById(Long id) {
//		Optional<Owner> opIdOwner=ownerRepository.findById(id);
//		if(opIdOwner.isPresent()) {
//			Owner dbIdOwner=opIdOwner.get();	
//		}
////		else {
////	return "Owner records does not found";
////		}
//		return owner;
//	}
	
	
}