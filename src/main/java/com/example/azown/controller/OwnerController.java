package com.example.azown.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.azown.entity.Owner;
import com.example.azown.service.OwnerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class OwnerController {
	
	@Autowired	
	OwnerService ownerService;
	@PostMapping("/Owner")
	public Owner createOwnerDetails(@RequestBody Owner owner){
	return ownerService.createOwnerDetails(owner);
	}
	
	@GetMapping("/Owner")
	public List<Owner> ListOfTheOwner(){
		return  ownerService.findAllOwnerDetails();
	}
	
	@PutMapping("/Owner")
	public Owner updateOwnerDetails (@RequestBody Owner owner, @RequestParam Long id) {
	return ownerService.editOwnerDetails(owner,id);
	}
	
	@DeleteMapping("/Owner/{id}")
	public String deleteOwnerDetails(@PathVariable Long id) {
		return ownerService.deleteOwnerDetailsById(id);
	}
	
	//OwnerdetailsfindBYID
	@GetMapping("/Owner/{id}")
	public String findOwnerDetailsById(@PathVariable Long id){
		return  ownerService.findOwnerDetailsById(id);
	}
	

	
}
