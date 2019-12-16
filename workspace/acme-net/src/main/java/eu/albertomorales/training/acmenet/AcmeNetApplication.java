package eu.albertomorales.training.acmenet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableFeignClients
//@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"eu.albertomorales.training.acmenet"})
public class AcmeNetApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcmeNetApplication.class, args);
	}

}
