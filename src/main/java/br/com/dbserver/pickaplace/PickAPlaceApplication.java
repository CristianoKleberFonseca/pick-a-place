package br.com.dbserver.pickaplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PickAPlaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickAPlaceApplication.class, args);
	}
}
