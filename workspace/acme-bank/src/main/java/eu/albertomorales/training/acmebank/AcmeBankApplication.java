package eu.albertomorales.training.acmebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"eu.albertomorales.training.acmebank"})
public class AcmeBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcmeBankApplication.class, args);
	}

}
