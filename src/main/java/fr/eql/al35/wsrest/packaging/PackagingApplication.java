package fr.eql.al35.wsrest.packaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PackagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagingApplication.class, args);
		System.out.println("http://localhost:8087");
	}

}
