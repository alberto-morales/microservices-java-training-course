package eu.albertomorales.training.acmenet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"eu.albertomorales.training.acmenet"})
public class AcmeNetApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcmeNetApplication.class, args);
	}

}
