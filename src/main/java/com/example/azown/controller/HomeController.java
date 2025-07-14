package com.example.azown.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to spring project";
	
	}



}
