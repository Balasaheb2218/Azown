package com.example.azown;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {


		@GetMapping("/Starter")
		public String SpringStarter() {
			return "Springboot Starter Project on port 8080";
		}
}
