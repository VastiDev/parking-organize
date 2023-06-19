package br.com.novaface.parkingorganizing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class ParkingOrganizingApplication {
	@GetMapping
	public String getHomeTeste(){
		return "Parking organize - API Home";
	}

	public static void main(String[] args) {
		SpringApplication.run(ParkingOrganizingApplication.class, args);
	}

}
