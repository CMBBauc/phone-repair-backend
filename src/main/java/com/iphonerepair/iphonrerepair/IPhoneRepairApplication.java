package com.iphonerepair.iphonrerepair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class IPhoneRepairApplication {

	public static void main(String[] args) {
		SpringApplication.run(IPhoneRepairApplication.class, args);
	}

}
